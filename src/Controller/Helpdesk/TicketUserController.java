package Controller.Helpdesk;

import Dao.Helpdesk.MessageDAO;
import Dao.Helpdesk.TicketDAO;
import Model.Helpdesk.Message;
import Model.Helpdesk.StateTicket;
import Model.Helpdesk.Ticket;
import Model.Util.Session;
import Model.Util.UserSession;
import View.Helpdesk.TicketPanel;
import View.Helpdesk.UserTicketView;


public class TicketUserController {
    private TicketDAO ticketDAO;
    private MessageDAO messageDAO;
    private UserTicketView userTicketView;

    public TicketUserController(TicketDAO ticketDAO, MessageDAO messageDAO, UserTicketView userTicketView) {
        this.ticketDAO = ticketDAO;
        this.messageDAO = messageDAO;
        this.userTicketView = userTicketView;

        if(!Session.getInstance().isAdmin()){
            userTicketView.getChatPanel().setIsAdmin(Session.getInstance().isAdmin());
            userTicketView.getChatPanel().setLoggedName(Session.getInstance().getIdentifier());
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
                StateTicket state=StateTicket.APERTO;
               // int id=ticketDAO.saveTicket(new Ticket(title,state));
                openChat(id, title,state.name());
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
          /*  for (Ticket ticket : ticketDAO.getAllTickets()) {
                TicketPanel panel = userTicketView.getSelectTicketPanel().loadTicket(
                        ticket.getTitle(),
                        ticket.getState().name(),
                        "Apri"
                );

                panel.getButton().addActionListener(e -> openChat(ticket.getId(), ticket.getTitle(), ticket.getState.name()));
           }*/
        });



        // CHAT: invia messaggio
        userTicketView.getChatPanel().getSendButton().addActionListener(e -> {
            String content = userTicketView.getChatPanel().getInputText();
            if (!content.isEmpty()) {
                Message message = new Message(userTicketView.getChatPanel().getLoggedUser(), content);
                messageDAO.saveMessage(userTicketView.getChatPanel().getCurrentTicketId(), message);
                userTicketView.getChatPanel().displayMessage(message.getText(), message.getSender(), message.getMessage_date());
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
      //  List<Message> messages = messageDAO.getMessagesByTicketId(ticketId);
        userTicketView.showChatPanel(title, ticketId, status);
        for (Message message : messages) {
            userTicketView.getChatPanel().displayMessage(message.getText(), message.getSender(), message.getMessage_date());
        }

    }
}
