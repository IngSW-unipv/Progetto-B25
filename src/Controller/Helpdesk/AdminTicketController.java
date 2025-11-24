package Controller.Helpdesk;

import Dao.Helpdesk.MessageDAO;
import Dao.Helpdesk.TicketDAO;
import Model.Helpdesk.Message;
import Model.Helpdesk.StateTicket;
import Model.Helpdesk.Ticket;
import Model.Util.DataConverter;
import Model.Util.Session;
import View.Helpdesk.AdminTicketView;
import View.Helpdesk.TicketPanel;
import java.util.ArrayList;


public class AdminTicketController {
    private TicketDAO ticketDAO;
    private MessageDAO messageDAO;
    private AdminTicketView adminTicketView;
    private boolean isAdmin;
    private String identifier;

    public AdminTicketController(TicketDAO ticketDAO, MessageDAO messageDAO, AdminTicketView adminTicketView) {
        this.ticketDAO = ticketDAO;
        this.messageDAO = messageDAO;
        this.adminTicketView = adminTicketView;

        if(Session.getInstance().isAdmin()){
            isAdmin=Session.getInstance().isAdmin();
            identifier=Session.getInstance().getIdentifier();
            adminTicketView.getChatPanel().setIsAdmin(isAdmin);
            adminTicketView.getChatPanel().setLoggedName(identifier);
        }
        setupListeners();
    }

    private void setupListeners() {
        // HOME: prendi a carico un ticket
        adminTicketView.getNavPanel().getButton("Prendi a carico un ticket").addActionListener(e ->{
            adminTicketView.showHandleSelectPanel();
        for (Ticket ticket : ticketDAO.selectOpenTicket()) {
            TicketPanel panel = adminTicketView.getHandleSelectPanel().loadTicket(
                    ticket.getTitle(),
                    ticket.getState().name(),
                    "Apri"
            );

            panel.getButton().addActionListener(ev -> {
                StateTicket handle=StateTicket.IN_CORSO;
                ticketDAO.updateState(ticket.getTicket_id(), handle);
                Message message = new Message("Ciao, sono " +identifier+" e sono qui per assisterti",
                        ticket.getTicket_id(),adminId);

                messageDAO.createMessage(message);
                openChat(ticket.getTicket_id(), ticket.getTitle(), handle.name());
            });
        }
    });



        //lISTA TICKET: presi in carico
        adminTicketView.getNavPanel().getButton("Seleziona Ticket").addActionListener(e ->{
            adminTicketView.showViewSelectPanel();
            for (Ticket ticket : ticketDAO.selectManagedTicket(adminId)) {
                TicketPanel panel = adminTicketView.getViewSelectPanel().loadTicket(
                        ticket.getTitle(),
                        ticket.getState().name(),
                        "Apri"
                );

                panel.getButton().addActionListener(ev -> openChat(ticket.getTicket_id(), ticket.getTitle(), ticket.getState().name()));
            }
        });



        // CHAT: invia messaggio
        adminTicketView.getChatPanel().getSendButton().addActionListener(e -> {
            String content = adminTicketView.getChatPanel().getInputText();
            if (!content.isEmpty()) {
                Message message = new Message(content,adminTicketView.getChatPanel().getCurrentTicketId(),adminId);
                messageDAO.createMessage(message);
                String formatDateTime= DataConverter.joinstring(DataConverter.dateconverter(message.getMessage_date()),
                        DataConverter.timeconverter(message.getMessage_time()));
                adminTicketView.getChatPanel().displayMessage(message.getText(), identifier, formatDateTime);
                adminTicketView.getChatPanel().clearInput();
            }
        });

        // CHAT: invia messaggio
        adminTicketView.getChatPanel().closeTicketButton().addActionListener(e -> {
            ticketDAO.updateState(adminTicketView.getChatPanel().getCurrentTicketId(), StateTicket.CHIUSO);
            adminTicketView.getChatPanel().openMode(false);

        });



        /* HOME: logout
        adminTicketView.getNavPanel().getButton("Logout").addActionListener(e ->
                adminTicketView.showCreateTicketPanel()
        );*/


    }

    private void openChat(int ticketId, String title, String status) {
        ArrayList<Message> messages = messageDAO.selectByTicketId(ticketId);
        adminTicketView.showChatPanel(title, ticketId, status);
        for (Message message : messages) {
            String formatDateTime= DataConverter.joinstring(DataConverter.dateconverter(message.getMessage_date()),
                    DataConverter.timeconverter(message.getMessage_time()));
            adminTicketView.getChatPanel().displayMessage(message.getText(), message.getSender(), formatDateTime);
        }

    }
}
