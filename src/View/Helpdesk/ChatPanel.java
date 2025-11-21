package View.Helpdesk;


import javax.swing.*;
import java.awt.*;


public class ChatPanel extends JPanel {

    private JPanel messagePanel;
    private JScrollPane scrollPane;
    private JTextField inputField;
    private JButton sendButton;
    private JButton backButton;
    private JButton closeTicketButton;
    private JLabel chatTitleLabel;
    private JLabel infoLabel;
    private JPanel inputPanel = new JPanel();

    private String loggedName;
    private boolean isAdmin;
    private int currentTicketId;

    public ChatPanel() {

        setLayout(new BorderLayout());

        chatTitleLabel = new JLabel("Chat", SwingConstants.CENTER);
        add(chatTitleLabel, BorderLayout.NORTH);

        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(messagePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);


        inputField = new JTextField(20);
        sendButton = new JButton("Invia");
        backButton = new JButton("Indietro");

        inputPanel.add(inputField);
        inputPanel.add(sendButton);
        inputPanel.add(backButton);

        if (isAdmin) {
            closeTicketButton = new JButton("Chiudi Ticket");
            infoLabel = new JLabel("con questo tasto chiudi definitivamente il ticket");
            inputPanel.add(closeTicketButton);
            inputPanel.add(infoLabel);
        }

        add(inputPanel, BorderLayout.SOUTH);
    }

    public void loadChat(String ticketTitle, int ticketId, String status) {
        this.currentTicketId = ticketId;
        chatTitleLabel.setText("Ticket: " + ticketTitle + "  Stato ticket: " + status);
        messagePanel.removeAll();

        boolean isClosed = ("CHIUSO".equals(status));
        inputField.setVisible(!isClosed);
        sendButton.setVisible(!isClosed);
        closeTicketButton.setVisible(!isClosed);
        infoLabel.setVisible(!isClosed);

        if (isClosed) {
            JLabel closedLabel = new JLabel("Il ticket è chiuso", SwingConstants.CENTER);
            inputPanel.add(closedLabel);  // Aggiungiamo la JLabel vicino al tasto "Back"
        }

        revalidate();
        repaint();

    }

    public void displayMessage(String content, String sender, String timestamp) {
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BorderLayout());
        wrapper.setBackground(sender.equals(loggedName) ? new Color(0xD1E8E2) : new Color(0xF1F1F1));

        // Messaggio principale con il mittente
        JLabel messageLabel = new JLabel("<html><b>" + sender + ":</b> " + content + "</html>");
        messageLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 10));

        // Etichetta per la data e l’ora
        JLabel timestampLabel = new JLabel(timestamp);
        timestampLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
        timestampLabel.setForeground(Color.DARK_GRAY);
        timestampLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        timestampLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 10));

        // Contenitore per messaggio e orario
        JPanel messageContent = new JPanel(new BorderLayout());
        messageContent.setOpaque(false);
        messageContent.add(messageLabel, BorderLayout.CENTER);
        messageContent.add(timestampLabel, BorderLayout.SOUTH);

        // Allineamento del messaggio a destra o sinistra
        JPanel alignedWrapper = new JPanel(new FlowLayout(sender.equals(loggedName) ? FlowLayout.RIGHT : FlowLayout.LEFT));
        alignedWrapper.setOpaque(false);
        wrapper.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        wrapper.add(messageContent, BorderLayout.CENTER);
        alignedWrapper.add(wrapper);

        messagePanel.add(alignedWrapper);
        messagePanel.revalidate();
        messagePanel.repaint();

        SwingUtilities.invokeLater(() -> {
            JScrollBar vertical = scrollPane.getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());
        });
    }

    public boolean getIsAdmin() {return isAdmin;}
    public void setIsAdmin(boolean isAdmin) {this.isAdmin = isAdmin;}
    public String getLoggedName() {return loggedName;}
    public void setLoggedName(String loggedName) {this.loggedName = loggedName;}
    public String getInputText() { return inputField.getText(); }
    public void clearInput() { inputField.setText(""); }
    public int getCurrentTicketId() { return currentTicketId; }

    public JButton getSendButton() { return sendButton; }
    public JButton getBackButton() { return backButton; }
    public JButton closeTicketButton() { return backButton; }
}
