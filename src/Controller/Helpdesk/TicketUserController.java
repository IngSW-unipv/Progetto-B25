package Controller.Helpdesk;

import Dao.Helpdesk.MessageDAO;
import Dao.Helpdesk.TicketDAO;
import Model.Helpdesk.Message;
import Model.Helpdesk.StateTicket;
import Model.Helpdesk.Ticket;
import Model.Util.DataConverter;
import Model.Util.Session;
import View.Helpdesk.TicketPanel;
import View.Helpdesk.UserTicketView;

import java.util.List;


public class TicketUserController {
    private TicketDAO ticketDAO;
    private MessageDAO messageDAO;
    private UserTicketView userTicketView;
    private boolean isAdmin;
    private String identifier;

    public TicketUserController(TicketDAO ticketDAO, MessageDAO messageDAO, UserTicketView userTicketView) {
        this.ticketDAO = ticketDAO;
        this.messageDAO = messageDAO;
        this.userTicketView = userTicketView;

        if(!Session.getInstance().isAdmin()){
            isAdmin=Session.getInstance().isAdmin();
            identifier=Session.getInstance().getIdentifier();
            userTicketView.getChatPanel().setIsAdmin(isAdmin);
            userTicketView.getChatPanel().setLoggedName(identifier);
        }
        setupListeners();
    }

    private void setupListeners() {
        // HOME: crea ticket
        userTicketView.getNavPanel().getButton("Crea Ticket").addActionListener(e ->
                userTicketView.showCreateTicketPanel()
        );

        // CREA TICKET: conferma creazione
        userTicketView.getCreateTicketPanel().getConfirmFindButton().addActionListener(e -> {
            String title = userTicketView.getCreateTicketPanel().getInput();
            if (title != null && !title.isEmpty()) {
                Ticket ticket= new Ticket(title,userid);
                ticketDAO.createTicket(ticket);
                openChat(ticket.getTicket_id(), title,ticket.getState().name());
            } else {
                //userTicketView.showHomePanel();
            }
        });

        // CREA TICKET: annulla creazione
        userTicketView.getCreateTicketPanel().getCancelFindButton().addActionListener(e ->
                userTicketView.showCreateTicketPanel()
        );

        // HOME: visualizza lista ticket
        userTicketView.getNavPanel().getButton("Seleziona Ticket").addActionListener(e ->
                userTicketView.showSelectTicketPanel()
        );

        //lISTA TICKET: selzione ticket
        userTicketView.getNavPanel().getButton("Seleziona Ticket").addActionListener(e -> {
            for (Ticket ticket : ticketDAO.getAllTickets()) {
                TicketPanel panel = userTicketView.getSelectTicketPanel().loadTicket(
                        ticket.getTitle(),
                        ticket.getState().name(),
                        "Apri"
                );

                panel.getButton().addActionListener(ev -> openChat(ticket.getTicket_id(), ticket.getTitle(), ticket.getState().name()));
           }
        });



        // CHAT: invia messaggio
        userTicketView.getChatPanel().getSendButton().addActionListener(e -> {
            String content = userTicketView.getChatPanel().getInputText();
            if (!content.isEmpty()) {
                Message message = new Message(content,userTicketView.getChatPanel().getCurrentTicketId(),0);
                messageDAO.createMessage(message);
                String formatDateTime= DataConverter.joinstring(DataConverter.dateconverter(message.getMessage_date()),
                                DataConverter.timeconverter(message.getMessage_time()));
                userTicketView.getChatPanel().displayMessage(message.getText(), identifier, formatDateTime);
                userTicketView.getChatPanel().clearInput();
            }
        });


        // CHAT: torna a lISTA TICKET
        userTicketView.getChatPanel().getBackButton().addActionListener(e ->
                //cambio stato ticket (dao)
                userTicketView.showSelectTicketPanel()
        );

        /* HOME: logout
        userTicketView.getNavPanel().getButton("Logout").addActionListener(e ->
                userTicketView.showCreateTicketPanel()
        );*/


    }

    private void openChat(int ticketId, String title, String status) {
        List<Message> messages = messageDAO.selectByTicketId(ticketId);
        userTicketView.showChatPanel(title, ticketId, status);
        for (Message message : messages) {
            String formatDateTime= DataConverter.joinstring(DataConverter.dateconverter(message.getMessage_date()),
                    DataConverter.timeconverter(message.getMessage_time()));
            userTicketView.getChatPanel().displayMessage(message.getText(), message.getSender(), formatDateTime);
        }

    }
}
