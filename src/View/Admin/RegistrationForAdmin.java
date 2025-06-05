package View.Admin;

import javax.swing.*;
import java.awt.*;

public class RegistrationForAdmin extends JPanel {
    String [] Admins  ={ " GAMES_ADMIN", "TOURNAMENT_ADMIN", "HELPDESK_ADMIN", "SUPER_ADMIN", "WALLET_ADMIN"};

    JButton registerButton = new JButton("RegistrazioneAdmin");
    JLabel nameLabel = new JLabel("name:");
    JLabel surnameLabel = new JLabel("surname:");
    JLabel RoleLabel = new JLabel("Role:");
    JTextField nameField = new JTextField();
    JTextField surnameField = new JTextField();
    JComboBox roleField = new JComboBox<>(Admins);




    public RegistrationForAdmin() {

        JLabel titleLabel = new JLabel("Admin Registrazione");
        add(titleLabel, BorderLayout.NORTH);

        JPanel registrationPanel = new JPanel();
        registrationPanel.setBackground(Color.lightGray);
        registrationPanel.setLayout(new GridLayout(7,1,10,10));
        add(registrationPanel, BorderLayout.CENTER);

        registrationPanel.add(nameLabel);
        registrationPanel.add(surnameLabel);
        registrationPanel.add(nameField);
        registrationPanel.add(surnameField);
        registrationPanel.add(RoleLabel);
        registrationPanel.add(roleField);
        registrationPanel.add(registerButton);
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public void setRegisterButton(JButton registerButton) {
        this.registerButton = registerButton;
    }

    public JComboBox getRoleField() {
        return roleField;
    }

    public void setRoleField(JComboBox roleField) {
        this.roleField = roleField;
    }

    public JLabel getRoleLabel() {
        return RoleLabel;
    }

    public void setRoleLabel(JLabel roleLabel) {
        RoleLabel = roleLabel;
    }

    public JTextField getSurnameField() {
        return surnameField;
    }

    public void setSurnameField(JTextField surnameField) {
        this.surnameField = surnameField;
    }

    public JLabel getSurnameLabel() {
        return surnameLabel;
    }

    public void setSurnameLabel(JLabel surnameLabel) {
        this.surnameLabel = surnameLabel;
    }
}


