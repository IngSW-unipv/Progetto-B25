package Dao.Helpdesk;


import Model.Helpdesk.StateTicket;
import Model.Helpdesk.Ticket;
import Model.Util.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TicketDAO implements ITicketDAO{

    private Connection conn;


    public boolean createTicket(Ticket ticket){

        conn= DBConnection.startConnection(conn);
        PreparedStatement st1;

        boolean outcome=true;

        try
        {
            String query="INSERT INTO TICKET (TITOLO,STATO,USER_ID,DATA_CREAZIONE) VALUES(?,?,?,?)";
            st1 = conn.prepareStatement(query);
            st1.setString(1,ticket.getTitle());
            st1.setString(2,ticket.getState().name());
            st1.setInt(3,ticket.getUser_id());
            st1.setDate(4, Date.valueOf(ticket.getCreation_date()));

            int affectedRows = st1.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = st1.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        ticket.setTicket_id(generatedId);  // salva l'id dentro all'oggetto Message
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


    public boolean updateState(int ticketId, StateTicket state){

        conn= DBConnection.startConnection(conn);
        PreparedStatement st1;

        boolean outcome=true;

        try {
            conn = DBConnection.startConnection(conn);
            String query = "UPDATE TICKET SET STATO = ? WHERE TICKET_ID = ?";
            st1 = conn.prepareStatement(query);

            // Imposta il valore enum come stringa nel DB
            st1.setString(1, state.name());
            st1.setInt(2, ticketId);

            st1.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            outcome = false;
        }

        DBConnection.closeConnection(conn);
        return outcome;

    }


    public Ticket selectById(int ticketId){

        Ticket t=null;

        conn=DBConnection.startConnection(conn);
        PreparedStatement st1;
        ResultSet rs1;

        try
        {
            String query="SELECT * FROM TICKET WHERE TICKET_ID=?";

            st1 = conn.prepareStatement(query);
            st1.setInt(1, ticketId);

            rs1=st1.executeQuery();

            while(rs1.next())
            {
                t= new Ticket(rs1.getInt(1), rs1.getString(2),StateTicket.valueOf(rs1.getString(3)),
                        rs1.getInt(4), rs1.getDate(5).toLocalDate());

            }
        }catch (Exception e){e.printStackTrace();}

        DBConnection.closeConnection(conn);
        return t;

    }


}
