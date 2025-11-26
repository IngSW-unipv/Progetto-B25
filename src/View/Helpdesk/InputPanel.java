package View.Helpdesk;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {

    private JTextField input;
    private JButton confirmFindButton;
    private JLabel errorLabel;

    public InputPanel(String title, String buttonText) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel(title);
        input = new JTextField(20);
        confirmFindButton = new JButton(buttonText);

        errorLabel = new JLabel();
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        add(titleLabel);
        add(input);
        add(errorLabel);
        add(Box.createVerticalStrut(5));
        add(confirmFindButton);
    }

    public JTextField getInputField() { return input; }
    public String getInput() { return input.getText(); }
    public void clearField() { input.setText(""); }
    public JButton getConfirmFindButton() { return confirmFindButton; }
    public JLabel getErrorLabel() { return errorLabel; }
}
