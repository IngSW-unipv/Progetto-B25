package Dao.Helpdesk;

import Model.Helpdesk.StateTicket;
import Model.Helpdesk.Ticket;

import java.util.ArrayList;

public interface ITicketDAO {
    public boolean createTicket(Ticket ticket);
    public boolean updateState(int ticketId, StateTicket state);
    public ArrayList<Ticket> selectByUserId(int userId);
    public ArrayList<Ticket> selectOpenTicket();
    public ArrayList<Ticket> selectManagedTicket(int adminId);



}
