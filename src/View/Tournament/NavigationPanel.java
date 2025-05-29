package View.Tournament;

import javax.swing.*;
import java.awt.*;

public class NavigationPanel extends JPanel {
    private JButton btnHome;
    private JButton btnAllTournaments;
    private JButton btnMyTournaments;

 public NavigationPanel() {
     setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
     setBackground(new Color(40,40,40));
     setPreferredSize(new Dimension(180, 600));

     btnHome = createNavButton("Home");
     btnAllTournaments = createNavButton("All Tournaments");
     btnMyTournaments = createNavButton("My Tournaments");

     add(Box.createVerticalGlue());

     add(btnHome);
     add(Box.createVerticalStrut(10));
     add(btnAllTournaments);
     add(Box.createVerticalStrut(10));
     add(btnMyTournaments);


 }


    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(160, 40));
        return button;
    }





    //GETTER

    public JButton getBtnHome() {
        return btnHome;
    }

    public JButton getBtnAllTournaments() {
        return btnAllTournaments;
    }

    public JButton getBtnMyTournaments() {
        return btnMyTournaments;
    }
}
