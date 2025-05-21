package Dao.Helpdesk;

import Model.Helpdesk.StateTicket;
import Model.Helpdesk.Ticket;

import java.util.ArrayList;

public interface ITicketDAO {
    public boolean createTicket(Ticket ticket);
    public boolean updateState(int ticketId, StateTicket state);
    //ArrayList<Ticket> selectByUser(int userId);
    public Ticket selectById(int ticketId);
    //ArrayList<Ticket> selectOpenTicket();
    // ArrayList<Ticket> selectManagedTicket();
}
