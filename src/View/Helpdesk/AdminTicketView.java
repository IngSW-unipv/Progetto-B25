package View.Helpdesk;

import javax.swing.*;
import java.awt.*;

public class AdminTicketView extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private String currentPanel; // Traccia il pannello attivo

    private NavigationPanel navPanel;
    private InputPanel findUserPanel;
    private TransactionPanel transactionPanel;
    private TicketListPanel handleSelectPanel;
    private TicketListPanel viewSelectPanel;
    private ChatPanel chatPanel;

    public AdminTicketView(String loggedName, boolean isAdmin) {
        currentPanel = "";

        setTitle("Servizio Helpdesk");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout principale
        getContentPane().setLayout(new BorderLayout());

        // --- Barra di navigazione ---
        navPanel = new NavigationPanel("Home","Prendi a carico un ticket","Seleziona Ticket","Effettua transazione");
        getContentPane().add(navPanel, BorderLayout.WEST);

        // --- Pannello centrale con CardLayout ---
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Inizializza pannelli
        findUserPanel = new InputPanel("Cerca utente per nome_utente", "Cerca", "Indietro");
        transactionPanel = new TransactionPanel();
        handleSelectPanel = new TicketListPanel();
        viewSelectPanel = new TicketListPanel();
        chatPanel = new ChatPanel();
        chatPanel.setLoggedName(loggedName);

        // Aggiungi i pannelli alla CardLayout
        mainPanel.add(findUserPanel, "FindUser");
        mainPanel.add(transactionPanel, "Transaction");
        mainPanel.add(handleSelectPanel, "HandleSelect");
        mainPanel.add(viewSelectPanel, "ViewSelect");
        mainPanel.add(chatPanel, "Chat");

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Mostra Home all'avvio
        currentPanel = "HandleSelect";
        cardLayout.show(mainPanel, "HandleSelect");

        // --- Listener bottoni nav bar ---
        //  navPanel. getButton("Home").addActionListener(e -> showHomePanel());
        navPanel. getButton("Prendi a carico un ticket").addActionListener(e -> showHandleSelectPanel()); // placeholder
        navPanel. getButton("Seleziona Ticket").addActionListener(e -> showViewSelectPanel());
        navPanel. getButton("Effettua transazione").addActionListener(e -> showFindUser());
    }


    public void showHandleSelectPanel() {
        if (!currentPanel.equals("HandleSelect")) {
            cardLayout.show(mainPanel, "HandleSelect");
            currentPanel = "HandleSelect";
        }
    }

    public void showViewSelectPanel() {
        if (!currentPanel.equals("ViewSelect")) {
            cardLayout.show(mainPanel, "ViewSelect");
            currentPanel = "ViewSelect";
        }
    }

    public void showFindUser() {
        if (!currentPanel.equals("FindUser")) {
            cardLayout.show(mainPanel, "FindUser");
            currentPanel = "FindUser";
        }
    }

    public void showTransaction() {
        if (!currentPanel.equals("Transaction")) {
            cardLayout.show(mainPanel, "Transaction");
            currentPanel = "Transaction";
        }
    }


    public void showChatPanel(String ticketTitle, int ticketId, String status) {
        if (!currentPanel.equals("Chat")) {
            chatPanel.loadChat(ticketTitle, ticketId, status);
            cardLayout.show(mainPanel, "Chat");
            currentPanel = "Chat";
        }
    }

    // --- Getters per controller ---
    public NavigationPanel getNavPanel() {
        return navPanel;
    }

    public InputPanel getFindUserPanel() {
        return findUserPanel;
    }

    public TransactionPanel getTransactionPanel() {
        return transactionPanel;
    }

    public TicketListPanel getHandleSelectPanel() {
        return handleSelectPanel;
    }

    public TicketListPanel getViewSelectPanel() {
        return viewSelectPanel;
    }

    public ChatPanel getChatPanel() {
        return chatPanel;
    }
}
