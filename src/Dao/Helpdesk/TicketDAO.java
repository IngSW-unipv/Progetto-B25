package Dao.Helpdesk;


import Model.Helpdesk.StateTicket;
import Model.Helpdesk.Ticket;
import Model.Tournament.StateTournament;
import Model.Tournament.Tournament;
import Model.Util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
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

    public ArrayList<Ticket> selectByUserId(int userId){

        conn = DBConnection.startConnection(conn);
        PreparedStatement st1;
        ResultSet rs1;
        ArrayList<Ticket> tickets = new ArrayList<>();

        try
        {
            String query = "SELECT * FROM TICKET WHERE USER_ID = ? " +
                    " ORDER BY CASE STATO " +
                    " WHEN 'IN_CORSO' THEN 1 " +
                    " WHEN 'APERTO' THEN 2 " +
                    " WHEN 'CHIUSO' THEN 3 " +
                    " END";

            st1 = conn.prepareStatement(query);
            st1.setInt(1, userId);


            rs1 = st1.executeQuery();

            while (rs1.next()) {

                Ticket t = new Ticket(
                        rs1.getInt(1),
                        rs1.getString(2),
                        StateTicket.valueOf(rs1.getString(3)),
                        rs1.getInt(4),
                        rs1.getDate(5).toLocalDate()
                );
                tickets.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBConnection.closeConnection(conn);
        return tickets;
    }


    public ArrayList<Ticket> selectOpenTicket(){

        conn=DBConnection.startConnection(conn);
        PreparedStatement st1;
        ResultSet rs1;
        ArrayList<Ticket> tickets = new ArrayList<>();

        try
        {
            String query = "SELECT * FROM TICKET WHERE STATO=?";

            st1 = conn.prepareStatement(query);
            st1.setString(1, StateTicket.APERTO.name());

            rs1 = st1.executeQuery();


            while (rs1.next()) {

                Ticket t = new Ticket(
                        rs1.getInt(1),
                        rs1.getString(2),
                        StateTicket.valueOf(rs1.getString(3)),
                        rs1.getInt(4),
                        rs1.getDate(5).toLocalDate()
                );
                tickets.add(t);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnection.closeConnection(conn);
        return tickets;
    }


    public ArrayList<Ticket> selectManagedTicket(int adminId){

        conn = DBConnection.startConnection(conn);
        PreparedStatement st1;
        ResultSet rs1;
        ArrayList<Ticket> tickets = new ArrayList<>();

        try
        {
            String query = "SELECT DISTINCT t.* " +
                    "FROM TICKET t " +
                    "JOIN MESSAGE m ON t.ticket_id = m.ticket_id " +
                    "WHERE (t.STATO = ? OR t.STATO = ?) " +
                    "AND m.admin_id = ? " +
                    "ORDER BY CASE t.STATO " +
                    "    WHEN 'IN_CORSO' THEN 1 " +
                    "    WHEN 'CHIUSO' THEN 2 " +
                    "END";;


            st1 = conn.prepareStatement(query);

            st1.setString(1, StateTicket.IN_CORSO.name());
            st1.setString(2, StateTicket.CHIUSO.name());
            st1.setInt(3, adminId);

            rs1 = st1.executeQuery();

            while (rs1.next()) {

                Ticket t = new Ticket(
                        rs1.getInt(1),
                        rs1.getString(2),
                        StateTicket.valueOf(rs1.getString(3)),
                        rs1.getInt(4),
                        rs1.getDate(5).toLocalDate()
                );
                tickets.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBConnection.closeConnection(conn);
        return tickets;

    }






  /*  public Ticket selectById(int ticketId){

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

    }*/


}
