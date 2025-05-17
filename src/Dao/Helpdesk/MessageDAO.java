package Dao.Helpdesk;

import Model.Helpdesk.Message;
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
            st1.setInt(3,message.getAdmin_id());
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
            String query="SELECT * FROM MESSAGGIO WHERE TICKET_ID=?";

            st1 = conn.prepareStatement(query);
            st1.setInt(1, ticketId);

            rs1=st1.executeQuery();

            while(rs1.next())
            {
                Message m=new Message(rs1.getInt(1), rs1.getString(2),rs1.getInt(3),
                        rs1.getInt(4), rs1.getTime(5).toLocalTime(), rs1.getDate(6).toLocalDate());

                result.add(m);
            }
        }catch (Exception e){e.printStackTrace();}

        DBConnection.closeConnection(conn);
        return result;

    }

}
