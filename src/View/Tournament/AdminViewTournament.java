package View.Tournament;

import javax.swing.*;
import java.awt.*;

public class AdminViewTournament extends JPanel{

    public AdminViewTournament() {
        setLayout(new GridLayout(1,2, 10,10));
        setBackground(Color.WHITE);

        JPanel infoTournament = new JPanel();
        JPanel partecipantTable = new JPanel();

        add(infoTournament);
        add(partecipantTable);


        //Addiamo all'info panel tutte le informazioni del Torneo

    }
}
