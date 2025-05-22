package View.Helpdesk;

import javax.swing.*;
import java.awt.*;

public class NavigationPanel extends JPanel {
    private JButton btnHome;
    private JButton btnCreateTicket;
    private JButton btnSelectTicket;

    public NavigationPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(40, 40, 40));
        setPreferredSize(new Dimension(180, 600));

        btnHome = createNavButton("Home");
        btnCreateTicket = createNavButton("Crea Ticket");
        btnSelectTicket = createNavButton("Seleziona Ticket");

        add(Box.createVerticalGlue());

        add(btnHome);
        add(Box.createVerticalStrut(10));
        add(btnCreateTicket);
        add(Box.createVerticalStrut(10));
        add(btnSelectTicket);

        add(Box.createVerticalGlue());
    }

    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(160, 40));
        return button;
    }

    // Getters per controller o MainView
    public JButton getBtnHome() { return btnHome; }
    public JButton getBtnCreateTicket() { return btnCreateTicket; }
    public JButton getBtnSelectTicket() { return btnSelectTicket; }

}
