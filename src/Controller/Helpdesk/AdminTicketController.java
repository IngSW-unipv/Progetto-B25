package Controller.Helpdesk;

import Dao.Admin_Management.AdminDAO;
import Dao.Helpdesk.MessageDAO;
import Dao.Helpdesk.TicketDAO;
import Dao.User.UserDAO;
import Dao.Wallet.TransactionDAO;
import Dao.Wallet.WalletDAO;
import Model.Admin_Management.Admin;
import Model.Games_Storage.Played_Game;
import Model.Helpdesk.Message;
import Model.Helpdesk.StateTicket;
import Model.Helpdesk.Ticket;
import Model.User_Management.User;
import Model.Util.DataConverter;
import Model.Util.Session;
import Model.Wallet_Payment.Payment_Method;
import Model.Wallet_Payment.Payment_Type;
import Model.Wallet_Payment.Transaction;
import Model.Wallet_Payment.Wallet;
import View.Helpdesk.AdminTicketView;
import View.Helpdesk.TicketPanel;

import javax.swing.*;
import java.util.ArrayList;


public class AdminTicketController {
    private TicketDAO ticketDAO;
    private MessageDAO messageDAO;
    private UserDAO userDAO;
    private AdminDAO adminDAO;
    private TransactionDAO transactionDAO;
    private WalletDAO walletDAO;
    private Played_GameDAO playedGameDAO;
    private AdminTicketView adminTicketView;
    private int adminId;
    private String identifier;
    private String selectedUsername;

    public AdminTicketController(TicketDAO ticketDAO, MessageDAO messageDAO, UserDAO userDAO, AdminDAO adminDAO,
                                 TransactionDAO transactionDAO, WalletDAO walletDAO, Played_GameDAO playedGameDAO, AdminTicketView adminTicketView) {
        this.ticketDAO = ticketDAO;
        this.messageDAO = messageDAO;
        this.userDAO = userDAO;
        this.adminDAO = adminDAO;
        this.transactionDAO = transactionDAO;
        this.walletDAO = walletDAO;
        this.playedGameDAO = playedGameDAO;
        this.adminTicketView = adminTicketView;

        if(Session.getInstance().isAdmin()){
            boolean isAdmin = Session.getInstance().isAdmin();
            identifier=Session.getInstance().getIdentifier();
            adminTicketView.getChatPanel().setIsAdmin(isAdmin);
            adminTicketView.getChatPanel().setLoggedName(identifier);

            Admin admin = adminDAO.selectByEmail(identifier);
            adminId=admin.getAdmin_id();
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
            String input = adminTicketView.getChatPanel().getInputText();
            String content = input == null ? "" : input.strip();

            if (!content.isBlank()) {
                Message message = new Message(content,adminTicketView.getChatPanel().getCurrentTicketId(),adminId);
                messageDAO.createMessage(message);
                String formatDateTime= DataConverter.joinstring(DataConverter.dateconverter(message.getMessage_date()),
                        DataConverter.timeconverter(message.getMessage_time()));
                adminTicketView.getChatPanel().displayMessage(message.getText(), identifier, formatDateTime);
                adminTicketView.getChatPanel().clearInput();
            }
        });

        // CHAT: chiusura ticket
        adminTicketView.getChatPanel().closeTicketButton().addActionListener(e -> {
            ticketDAO.updateState(adminTicketView.getChatPanel().getCurrentTicketId(), StateTicket.CHIUSO);
            adminTicketView.getChatPanel().openMode(false);

        });



        /* HOME: logout
        adminTicketView.getNavPanel().getButton("Logout").addActionListener(e ->
                adminTicketView.showCreateTicketPanel()
        );*/

        // HOME: apre il panello per ricercare utente
        adminTicketView.getNavPanel().getButton("Effettua transazione").addActionListener(e ->
                adminTicketView.showFindUser()
        );

        //PANNELLO INSERIMENTO UTENTE: utente da ricercare
        adminTicketView.getFindUserPanel().getConfirmFindButton().addActionListener(e -> {
            String input =adminTicketView.getFindUserPanel().getInput();
            String text = input == null ? "" : input.strip();

            if (!text.isBlank()) {
                User user = userDAO.selectByUsername(text);
                if (user != null) {
                    selectedUsername=text;
                    openTable(selectedUsername);
                }else{
                //
                }

            } else {
                //userTicketView.showHomePanel();
            }
        });

        //PANNELLO TRANSAZIONI: effettua transazione
        adminTicketView.getTransactionPanel().getConfirmTransactionButton().addActionListener(e -> {
            if (selectedUsername != null) {


                String input = adminTicketView.getTransactionPanel().getAmountField();
                String content = input == null ? "" : input.strip();

                if (!content.isBlank()) {
                    double amount;
                    try {
                        amount = Double.parseDouble(content);
                        if (amount > 0) {

                        Wallet wallet= walletDAO.selectByUsername(selectedUsername);
                        double newBalance = wallet.getBalance()+amount;
                        walletDAO.updateBalance(wallet.getWallet_id(),newBalance);

                        Transaction transaction= new Transaction(wallet.getWallet_id(), Payment_Type.RIMBORSO, Payment_Method.PAYPAL,
                                null, amount, wallet.getBalance(), newBalance, 0, adminId);

                        transactionDAO.createTransaction(transaction);

                        String formatDateTime= DataConverter.joinstring(DataConverter.dateconverter(transaction.getDate_transaction()),
                                    DataConverter.timeconverter(transaction.getTime_transaction()));

                            Object[] row = {
                                    transaction.getTransaction_id(),
                                    transaction.getTransaction_type(),
                                    transaction.getAmount(),
                                    transaction.getPre_currency(),
                                    transaction.getPost_currency(),
                                    formatDateTime,
                                    transaction.getPayment_method()
                            };

                            adminTicketView.getTransactionPanel().addTransaction(row);
                            adminTicketView.getTransactionPanel().clearInput();

                        }else{

                        }

                    } catch (NumberFormatException ex) {

                    }

                }else{

                }

            }
        });


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

    private void openTable (String username) {
        ArrayList<Transaction> transactions = transactionDAO.selectByUsername(username);
        ArrayList<Played_Game> playedGames = played_GameDAO.selectByUsername(username);
        adminTicketView.showTransaction();
        for (Transaction transaction : transactions) {

            String formatDateTime= DataConverter.joinstring(DataConverter.dateconverter(transaction.getDate_transaction()),
                    DataConverter.timeconverter(transaction.getTime_transaction()));

            Object[] row = {
                    transaction.getTransaction_id(),
                    transaction.getTransaction_type(),
                    transaction.getAmount(),
                    transaction.getPre_currency(),
                    transaction.getPost_currency(),
                    formatDateTime,
                    transaction.getPayment_method()
            };

            adminTicketView.getTransactionPanel().addTransaction(row);
        }

        for (Played_Game playedGame : playedGames) {

            String formatDateTime= DataConverter.joinstring(DataConverter.dateconverter(playedGame.getCreation_Date()),
                    DataConverter.timeconverter(playedGame.getCreation_Time()));

            Object[] row = {
                    playedGame.getPlayed_Game_id(),
                    playedGame.getGame_name(),
                    playedGame.getAmount_bet(),
                    playedGame.getAmount_won(),
                    playedGame.getAmount_before(),
                    playedGame.getAmount_after(),
                    formatDateTime,
            };

            adminTicketView.getTransactionPanel().addBet(row);
        }

    }
}
