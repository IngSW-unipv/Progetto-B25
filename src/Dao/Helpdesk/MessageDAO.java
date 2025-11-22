package Dao.Helpdesk;

import Model.Helpdesk.Message;
import Model.Helpdesk.StateTicket;
import Model.Helpdesk.Ticket;
import Model.Util.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class MessageDAO implements IMessageDAO {

    private Connection conn;



    public boolean createMessage(Message message){

        conn=DBConnection.startConnection(conn);
        PreparedStatement st1;

        boolean outcome=true;

        try
        {
            String query="INSERT INTO MESSAGGIO (TESTO_MESSAGGIO,TICKET_ID,ADMIN_ID,ORARIO_MESSAGGIO,DATA_MESSAGGIO) VALUES(?,?,?,?,?)";
            st1 = conn.prepareStatement(query);
            st1.setString(1, message.getText());
            st1.setInt(2,message.getTicket_id());

            if (message.getAdmin_id() == 0) {
                st1.setNull(3, java.sql.Types.INTEGER);
            } else {
                st1.setInt(3, message.getAdmin_id());
            }

            st1.setTime(4,Time.valueOf(message.getMessage_time()));
            st1.setDate(5,Date.valueOf(message.getMessage_date()));

            int affectedRows = st1.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = st1.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        message.setMessage_id(generatedId);  // salva l'id dentro all'oggetto Message
                    }
                }
            } else {
                outcome = false;
            }

        }catch (Exception e){
            e.printStackTrace();
            outcome=false;
        }

        DBConnection.closeConnection(conn);
        return outcome;

    }



    public ArrayList<Message> selectByTicketId(int ticketId){

        ArrayList<Message> result = new ArrayList<>();

        conn=DBConnection.startConnection(conn);
        PreparedStatement st1;
        ResultSet rs1;

        try
        {
            String query= "SELECT m.id_messaggio, m.testo_messaggio, m.ticket_id, m.admin_id, " +
                    "       m.orario_messaggio, m.data_messaggio, " +
                    "               CASE " +
                    "                   WHEN m.admin_id IS NULL THEN u.nome_utente " +
                    "                   ELSE a.email " +
                    "               END AS sender " +
                    "        FROM messaggio m " +
                    "        LEFT JOIN admin a ON m.admin_id = a.id " +
                    "        LEFT JOIN ticket t ON m.ticket_id = t.id " +
                    "        LEFT JOIN utente u ON t.user_id = u.id " +
                    "        WHERE m.ticket_id = ? " +
                    "        ORDER BY m.data_messaggio, m.orario_messaggio " ;


            st1 = conn.prepareStatement(query);
            st1.setInt(1, ticketId);

            rs1=st1.executeQuery();

            while(rs1.next())
            {
                Message m=new Message(rs1.getInt(1), rs1.getString(2),rs1.getInt(3),
                        rs1.getInt(4), rs1.getTime(5).toLocalTime(), rs1.getDate(6).toLocalDate());

                m.setSender(rs1.getString("sender"));

                result.add(m);
            }
        }catch (Exception e){e.printStackTrace();}

        DBConnection.closeConnection(conn);
        return result;

    }

}
