package View.Helpdesk;

import javax.swing.*;
import java.awt.*;

public class TicketPanel extends JPanel {
    private JButton btn1;

    public TicketPanel(String titolo, String status, String btn1Text) {
        setLayout(new BorderLayout());
        setBackground(new Color(0xF1F1F1));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));

        // Sinistra: info
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setOpaque(false);

        JLabel titoloLabel = new JLabel("<html><b>" + titolo + "</b></html>");
        JLabel statusLabel = new JLabel("Stato: " + status);
        statusLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        statusLabel.setForeground(Color.DARK_GRAY);

        infoPanel.add(titoloLabel);
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(statusLabel);

        // Destra: bottone singolo allineato a destra
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        buttonPanel.setOpaque(false);

        btn1 = new JButton(btn1Text);
        buttonPanel.add(btn1);

        add(infoPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);
    }

    public JButton getButton() {
        return btn1;
    }
}
