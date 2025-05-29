package View.Tournament;

import Model.Tournament.StateTournament;

import javax.swing.*;
import java.awt.*;

public class AllTournaments extends JPanel {
    private JButton subscribeButton;


    public AllTournaments(String title) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        //Titolo del panel
        JLabel Title = new JLabel(title);
        add(Title, BorderLayout.NORTH);

        //Pannello per le 'card'
        JPanel cardGrid = new JPanel();
        cardGrid.setLayout(new GridLayout(0, 3, 10,10));
        cardGrid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10,10));
        cardGrid.setBackground(Color.WHITE);

        //Per aggingere le card
//        for (int i = 0; i < numeroDiTorneiIscitto; i++) {
//            cardGrid.add(createTournamentCard("","", ""));
//        }


    }


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
        subscribeButton = new JButton("Subscribe");

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
        add(subscribeButton);


        return card;
    }




    //GETTER


    public JButton getSubscribeButton() {
        return subscribeButton;
    }
}
