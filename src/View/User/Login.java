package View.User;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel{
    JButton loginButton = new JButton("Login");
    public Login() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(Color.lightGray);
        loginPanel.setLayout(new GridLayout(2,2));
        add(loginPanel, BorderLayout.CENTER);
        loginPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();



        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

    }

    public JButton getLoginButton() {
        return loginButton;
    }
}
