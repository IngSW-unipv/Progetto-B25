package Dao.Helpdesk;

import Model.Helpdesk.Message;
import Model.Helpdesk.Ticket;

import java.util.ArrayList;

public interface IMessageDAO {
     public boolean createMessage(Message message);
     public ArrayList<Message> selectByTicketId(int ticketId);

}
