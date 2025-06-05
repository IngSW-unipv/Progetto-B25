package View.User;

import javax.swing.*;
import java.awt.*;

public class RegistrationForUser extends JPanel {
    JButton registerButton = new JButton("Registrazione");
    public RegistrationForUser() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel registrationPanel = new JPanel();
        registrationPanel.setBackground(Color.lightGray);
        registrationPanel.setLayout(new GridLayout(7,2,10,10));
        add(registrationPanel, BorderLayout.CENTER);


        JLabel nameLabel = new JLabel("Name: ");
        JLabel surnameLabel = new JLabel("Surname: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JLabel emailLabel = new JLabel("Email: ");
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel codicefiscaleLabel = new JLabel("COdice fiscale: ");


        JTextField nameField = new JTextField(10);
        JTextField surnameField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);
        JTextField emailField = new JTextField(10);
        JTextField usernameField = new JTextField(10);
        JTextField codicefiscaleField = new JTextField(10);


        registrationPanel.add(nameLabel);
        registrationPanel.add(nameField);
        registrationPanel.add(surnameLabel);
        registrationPanel.add(surnameField);
        registrationPanel.add(passwordLabel);
        registrationPanel.add(passwordField);
        registrationPanel.add(emailLabel);
        registrationPanel.add(emailField);
        registrationPanel.add(usernameLabel);
        registrationPanel.add(usernameField);
        registrationPanel.add(codicefiscaleLabel);
        registrationPanel.add(codicefiscaleField);



        registrationPanel.add(registerButton);
    }

    public JButton getRegisterButton() {
        return registerButton;
    }
}
