package View.Tournament;

import Model.Tournament.StateTournament;

import javax.swing.*;
import java.awt.*;

public class AdminAllTournaments extends AllTournaments{
    JButton viewButton;

    public AdminAllTournaments(String Title) {
        super(Title);
    }

    @Override
    public JPanel createTournamentCard(String nomeTorneo, int entryFee, StateTournament state){
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.LIGHT_GRAY);
        card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        card.setPreferredSize(new Dimension(100, 120));

        //Info delle card
        JLabel nomeTorneoLabel = new JLabel(nomeTorneo);
        JLabel entryFeeLabel = new JLabel(String.valueOf(entryFee));
        JLabel stateLabel = new JLabel(state.name());
        viewButton = new JButton("Vedi");

        card.add(nomeTorneoLabel);
        add(Box.createVerticalStrut(10));
        card.add(entryFeeLabel);
        add(Box.createVerticalStrut(5));
        card.add(stateLabel);

        //Creazione del pannello per i Bottoni
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(1,2,5,5));
        btnPanel.setBackground(Color.LIGHT_GRAY);
        card.add(btnPanel);
        add(viewButton);


        return card;
    }


    //GETTER

    public JButton getViewButton() {
        return viewButton;
    }
}
