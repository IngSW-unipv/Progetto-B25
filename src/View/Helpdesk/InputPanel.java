package View.Helpdesk;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {

    private JTextField input;
    private JButton confirmFindButton;
    private JButton cancelFindButton;

    public InputPanel(String title, String button1Text, String button2Text) {
        setLayout(new FlowLayout());
        input = new JTextField(20);
        confirmFindButton = new JButton(button1Text);
        cancelFindButton = new JButton(button2Text);

        add(new JLabel(title));
        add(input);
        add(confirmFindButton);
        add(cancelFindButton);
    }

    public String getInput() { return input.getText(); }
    public void clearField() { input.setText(""); }
    public JButton getConfirmFindButton() { return confirmFindButton; }
    public JButton getCancelFindButton() { return cancelFindButton; }

}
