package View.Tournament;

import javax.swing.*;
import java.awt.*;

public class AdminNavigationPanel extends JPanel {
    private JButton btnProfile;
    private JButton btnCreateTournament;
    private JButton btnViewTournament;

    public AdminNavigationPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(40,40,40));
        setPreferredSize(new Dimension(180, 600));

        btnProfile = new JButton("Profile");
        btnCreateTournament = new JButton("Create Tournament");
        btnViewTournament = new JButton("View Tournament");

        add(Box.createVerticalGlue());

        add(btnProfile);
        add(Box.createVerticalStrut(10));
        add(btnCreateTournament);
        add(Box.createVerticalStrut(10));
        add(btnViewTournament);
    }

    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(160, 40));
        return button;
    }



    //GETTER


    public JButton getBtnProfile() {
        return btnProfile;
    }

    public JButton getBtnCreateTournament() {
        return btnCreateTournament;
    }

    public JButton getBtnViewTournament() {
        return btnViewTournament;
    }
}
