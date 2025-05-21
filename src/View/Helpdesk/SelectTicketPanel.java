package View.Helpdesk;

import javax.swing.*;
import java.awt.*;

public class SelectTicketPanel extends JPanel {

    private JComboBox<String> ticketComboBox;
    private JButton confirmSelectButton;
    private JButton cancelSelectButton;

    public SelectTicketPanel(String title, String button1Text, String button2Text) {
        setLayout(new FlowLayout());
        ticketComboBox = new JComboBox<>();
        confirmSelectButton = new JButton(button1Text);
        cancelSelectButton = new JButton(button2Text);

        add(new JLabel(title));
        add(ticketComboBox);
        add(confirmSelectButton);
        add(cancelSelectButton);
    }

    public void setTicketTitles(String[] titles) {
        ticketComboBox.removeAllItems();
        for (String title : titles) {
            ticketComboBox.addItem(title);
        }
    }

    public int getSelectedTicketTitle() {
        return ticketComboBox.getSelectedIndex();
    }

    public JButton getConfirmSelectButton() { return confirmSelectButton; }
    public JButton getCancelSelectButton() { return cancelSelectButton; }
}
