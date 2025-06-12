package View.Games;
import javax.swing.*;
import java.awt.*;
import View.Helpdesk.NavigationPanel;
import View.Admin.AdminHomeView;

public class GamesforAdminMainView extends JPanel {
    AdminHomeView GamesAdminHomeView;
    public GamesforAdminMainView() {
        setLayout(new GridLayout(1,2, 10,10));
        setBackground(Color.WHITE);
        NavigationPanel NavigationBar = new NavigationPanel();
        JPanel infoGames = new JPanel();
        JPanel partecipantTable = new JPanel();
        add(infoGames);
        add(partecipantTable);

    }

}
