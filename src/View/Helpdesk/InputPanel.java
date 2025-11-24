package View.Helpdesk;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {

    private JTextField input;
    private JButton confirmFindButton;

    public InputPanel(String title, String button1Text) {
        setLayout(new FlowLayout());
        input = new JTextField(20);
        confirmFindButton = new JButton(button1Text);

        add(new JLabel(title));
        add(input);
        add(confirmFindButton);
    }

    public String getInput() { return input.getText(); }
    public void clearField() { input.setText(""); }
    public JButton getConfirmFindButton() { return confirmFindButton; }

}
