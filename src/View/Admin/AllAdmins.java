package View.Admin;
import View.Helpdesk.NavigationPanel;

import javax.swing.*;
import java.awt.*;

public class AllAdmins {
    /*private JPanel buildListPanel() {
        JPanel p = new JPanel(new BorderLayout(10,10));
        JLabel title = new JLabel("Gestione Admin Users", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD,20f));
        p.add(title, BorderLayout.NORTH);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        JScrollPane scroll = new JScrollPane(container,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        p.add(scroll, BorderLayout.CENTER);

        JButton add = new JButton("Aggiungi Admin");
        add.addActionListener(e -> showForm(null));
        p.add(add, BorderLayout.SOUTH);

        p.putClientProperty("container", container);
        return p;
    }

    private JPanel buildFormPanel() {
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        gbc.gridx = 0; gbc.gridy = 0; p.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1; userField = new JTextField(15); p.add(userField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; p.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; emailField = new JTextField(15); p.add(emailField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; p.add(new JLabel("Role:"), gbc);
        gbc.gridx = 1; roleField = new JTextField(15); p.add(roleField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; JButton save = new JButton("Save"); p.add(save, gbc);
        gbc.gridx = 1; JButton cancel = new JButton("Cancel"); p.add(cancel, gbc);
        save.addActionListener(this::onSave);
        cancel.addActionListener(e -> showList());

        return p;
    } */
}
