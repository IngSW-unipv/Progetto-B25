package View.Helpdesk;

import javax.swing.*;
import java.awt.*;

public class TicketListPanel extends JPanel {
    private final JPanel container;

    public TicketListPanel() {
        setLayout(new BorderLayout());

        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(container);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }

    public TicketPanel loadTicket(String titolo, String status, String btn1Text) {
        TicketPanel panel = new TicketPanel(titolo, status, btn1Text);
        container.add(panel);
        container.add(Box.createVerticalStrut(10));
        revalidate();
        repaint();
        return panel;
    }
}
