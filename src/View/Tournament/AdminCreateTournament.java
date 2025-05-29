package View.Tournament;

import javax.swing.*;
import java.awt.*;

public class AdminCreateTournament extends JPanel{
    private JLabel title;

    private JLabel nameTournament;
    private JTextField nameTournamentField;
    private JLabel entryFee;
    private JTextField entryFeeField;
    private JLabel tournamentStatus;
    private JComboBox tournamentTypeComboBox;
    private JLabel numMaxPlayers;
    private JTextField numMaxPlayersField;
    private JLabel levelRequirement;
    private JComboBox levelRequirementComboBox;
    private JLabel numRound;
    private JTextField numRoundField;
    private JLabel roundTime;
    private JTextField roundTimeField;
    private JLabel numFishround;
    private JTextField numFishroundField;
    private JLabel startTournamentDateTime;
    private JTextField startTournamentDateTimeField;
    private JButton btnCreateTournament;

    public AdminCreateTournament(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
        title = new JLabel("Crea Torneo");
        add(title);

        //Pannello per componenti Swing
        JPanel createPanel = new JPanel();
        createPanel.setLayout(new GridLayout(10,2,10,10));
        createPanel.setBackground(Color.WHITE);

        //Array per i ComboBox
        String [] status = {"Public", "Closed", "Started"};
        String [] level = {"Base", "Intermedio", "Avanzato"};

        //Label
        nameTournament = new JLabel("Nome torneo:");
        entryFee = new JLabel("Costo d'entrata:");
        tournamentStatus = new JLabel("Status");
        numMaxPlayers = new JLabel("Massimo giocatori:");
        levelRequirement = new JLabel("Livello Richiesto:");
        numRound = new JLabel("Numero di round:");
        roundTime = new JLabel("Tempo per round:");
        numFishround = new JLabel("Fish per round:");
        startTournamentDateTime = new JLabel("Data e ora di inizio:");

        btnCreateTournament = new JButton("Crea torneo");

        //TextField e ComboBox
        nameTournamentField = new JTextField(10);
        entryFeeField = new JTextField(10);
        tournamentTypeComboBox= new JComboBox(status);
        numMaxPlayersField = new JTextField(10);
        levelRequirementComboBox = new JComboBox(level);
        numRoundField = new JTextField(10);
        roundTimeField = new JTextField(10);
        numFishroundField = new JTextField(10);
        startTournamentDateTimeField = new JTextField(10);



        //Add al Pannello
        createPanel.add(nameTournament);
        createPanel.add(nameTournamentField);
        createPanel.add(entryFee);
        createPanel.add(entryFeeField);
        createPanel.add(tournamentStatus);
        createPanel.add(tournamentTypeComboBox);
        createPanel.add(numMaxPlayers);
        createPanel.add(numMaxPlayersField);
        createPanel.add(levelRequirement);
        createPanel.add(levelRequirementComboBox);
        createPanel.add(numRound);
        createPanel.add(numRoundField);
        createPanel.add(roundTime);
        createPanel.add(roundTimeField);
        createPanel.add(numFishround);
        createPanel.add(numFishroundField);
        createPanel.add(startTournamentDateTime);
        createPanel.add(startTournamentDateTimeField);
        createPanel.add(btnCreateTournament);

    }


    //GETTER

    public JButton getBtnCreateTournament() {
        return btnCreateTournament;
    }

    public JTextField getNameTournamentField() {
        return nameTournamentField;
    }

    public JTextField getEntryFeeField() {
        return entryFeeField;
    }

    public JComboBox getLevelRequirementComboBox() {
        return levelRequirementComboBox;
    }

    public JTextField getNumMaxPlayersField() {
        return numMaxPlayersField;
    }

    public JComboBox getTournamentTypeComboBox() {
        return tournamentTypeComboBox;
    }

    public JTextField getNumRoundField() {
        return numRoundField;
    }

    public JTextField getRoundTimeField() {
        return roundTimeField;
    }

    public JTextField getNumFishroundField() {
        return numFishroundField;
    }

    public JTextField getStartTournamentDateTimeField() {
        return startTournamentDateTimeField;
    }
}
