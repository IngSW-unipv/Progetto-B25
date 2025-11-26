package View.Helpdesk;

import View.Util.InputErrorAlert;

import javax.swing.*;
import java.awt.*;

public class UserTicketView extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private String currentPanel; // Traccia il pannello attivo

    private NavigationPanel navPanel;
    private InputPanel createTicketPanel;
    private TicketListPanel selectTicketPanel;
    private ChatPanel chatPanel;

    public UserTicketView() {
        currentPanel = "";

        setTitle("Servizio Helpdesk");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout principale
        getContentPane().setLayout(new BorderLayout());

        // --- Barra di navigazione ---
        navPanel = new NavigationPanel("Home","Crea Ticket","Seleziona Ticket");
        getContentPane().add(navPanel, BorderLayout.WEST);

        // --- Pannello centrale con CardLayout ---
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Inizializza pannelli
        createTicketPanel = new InputPanel("inserisci il titolo del tuo ticket", "Crea");
        selectTicketPanel = new TicketListPanel();
        chatPanel = new ChatPanel();

        // Aggiungi i pannelli alla CardLayout
        mainPanel.add(createTicketPanel, "CreateTicket");
        mainPanel.add(selectTicketPanel, "SelectTicket");
        mainPanel.add(chatPanel, "Chat");

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Mostra Home all'avvio
        currentPanel = "CreateTicket";
        cardLayout.show(mainPanel, "CreateTicket");

    }


    public void showCreateTicketPanel(InputErrorAlert errorAlert) {
        if (!currentPanel.equals("CreateTicket")) {
            createTicketPanel.clearField();
            errorAlert.clearAll();
            cardLayout.show(mainPanel, "CreateTicket");
            currentPanel = "CreateTicket";
        }
    }

    public void showSelectTicketPanel() {
        if (!currentPanel.equals("SelectTicket")) {
            cardLayout.show(mainPanel, "SelectTicket");
            currentPanel = "SelectTicket";
        }
    }

    public void showChatPanel(String ticketTitle, int ticketId, String status) {
        if (!currentPanel.equals("Chat")) {
            chatPanel.clearInput();
            chatPanel.loadChat(ticketTitle, ticketId, status);
            cardLayout.show(mainPanel, "Chat");
            currentPanel = "Chat";
        }
    }

    // --- Getters per controller ---
    public NavigationPanel getNavPanel() {
        return navPanel;
    }


    public InputPanel getCreateTicketPanel() {
        return createTicketPanel;
    }

    public TicketListPanel getSelectTicketPanel() {
        return selectTicketPanel;
    }

    public ChatPanel getChatPanel() {
        return chatPanel;
    }
}
