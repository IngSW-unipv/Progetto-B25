package Controller.Helpdesk;

import Dao.Helpdesk.MessageDAO;
import Dao.Helpdesk.TicketDAO;
import Dao.User.UserDAO;
import Model.Helpdesk.Message;
import Model.Helpdesk.Ticket;
import Model.User_Management.User;
import Model.Util.DataConverter;
import Model.Util.Session;
import View.Helpdesk.TicketPanel;
import View.Helpdesk.UserTicketView;
import View.Util.InputErrorAlert;

import java.util.ArrayList;



public class UserTicketController {
    private TicketDAO ticketDAO;
    private MessageDAO messageDAO;
    private UserDAO userDAO;
    private UserTicketView userTicketView;
    private int userId;
    private String identifier;
    private InputErrorAlert errorAlert;

    public UserTicketController(TicketDAO ticketDAO, MessageDAO messageDAO, UserDAO userDAO, UserTicketView userTicketView) {
        this.ticketDAO = ticketDAO;
        this.messageDAO = messageDAO;
        this.userDAO = userDAO;
        this.userTicketView = userTicketView;

        if(!Session.getInstance().isAdmin()){
            boolean isAdmin = Session.getInstance().isAdmin();
            identifier=Session.getInstance().getIdentifier();
            userTicketView.getChatPanel().setIsAdmin(isAdmin);
            userTicketView.getChatPanel().setLoggedName(identifier);

            User user = userDAO.selectByUsername(identifier);
            userId=user.getUser_id();

            errorAlert = new InputErrorAlert();
            errorAlert.registerField(userTicketView.getCreateTicketPanel().getInputField(),
                    userTicketView.getCreateTicketPanel().getErrorLabel());
        }


        setupListeners();
    }

    private void setupListeners() {
        // HOME: crea ticket
        userTicketView.getNavPanel().getButton("Crea Ticket").addActionListener(e ->
                userTicketView.showCreateTicketPanel(errorAlert)
        );

        // CREA TICKET: conferma creazione
        userTicketView.getCreateTicketPanel().getConfirmFindButton().addActionListener(e -> {
            String input = userTicketView.getCreateTicketPanel().getInput();
            String title = input == null ? "" : input.strip();
            if (!title.isBlank()) {
                errorAlert.clearAll();
                Ticket ticket= new Ticket(title,userId);
                ticketDAO.createTicket(ticket);
                openChat(ticket.getTicket_id(), title,ticket.getState().name());
            } else {
                errorAlert.showError(userTicketView.getCreateTicketPanel().getInputField(), "Il titolo non può essere vuoto");
            }
        });


        //lISTA TICKET: selzione ticket
        userTicketView.getNavPanel().getButton("Seleziona Ticket").addActionListener(e -> {
            userTicketView.showSelectTicketPanel();
            for (Ticket ticket : ticketDAO.selectByUserId(userId)) {
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
            String input = userTicketView.getChatPanel().getInputText();
            String content = input == null ? "" : input.strip();

            if (!content.isBlank()) {
                Message message = new Message(content,userTicketView.getChatPanel().getCurrentTicketId(),0);
                messageDAO.createMessage(message);
                String formatDateTime= DataConverter.joinstring(DataConverter.dateconverter(message.getMessage_date()),
                                DataConverter.timeconverter(message.getMessage_time()));
                userTicketView.getChatPanel().displayMessage(message.getText(), identifier, formatDateTime);
                userTicketView.getChatPanel().clearInput();
            }
        });



        /* HOME: logout
        userTicketView.getNavPanel().getButton("Home").addActionListener(e ->
                userTicketView.showCreateTicketPanel()
        );*/


    }

    private void openChat(int ticketId, String title, String status) {
        ArrayList<Message> messages = messageDAO.selectByTicketId(ticketId);
        userTicketView.showChatPanel(title, ticketId, status);
        for (Message message : messages) {
            String formatDateTime= DataConverter.joinstring(DataConverter.dateconverter(message.getMessage_date()),
                    DataConverter.timeconverter(message.getMessage_time()));
            userTicketView.getChatPanel().displayMessage(message.getText(), message.getSender(), formatDateTime);
        }

    }
}
