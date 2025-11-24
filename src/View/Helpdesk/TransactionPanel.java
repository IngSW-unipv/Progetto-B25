package View.Helpdesk;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TransactionPanel extends JPanel {

    private JTable tableTransaction;
    private DefaultTableModel modelTransaction;
    private JTable tableBet;
    private DefaultTableModel modelBet;
    JTextField amountField;
    JButton confirmTransactionButton;

    public TransactionPanel() {
        setLayout(new BorderLayout());

        // colonne della tabella transazioni
        String[] columnTransNames = {"ID transazione", "Tipo Transazione", "Importo" ,"Data Transazione","metodo pagamento"};
        modelTransaction = new DefaultTableModel(columnTransNames, 0);
        tableTransaction = new JTable(modelTransaction);
        JScrollPane scrollPaneTransaction = new JScrollPane(tableTransaction);
        JPanel transPanel = new JPanel(new BorderLayout());
        transPanel.add(new JLabel("Transazioni", JLabel.CENTER), BorderLayout.NORTH);
        transPanel.add(scrollPaneTransaction, BorderLayout.CENTER);

        // colonne della tabella giocate
        String[] columnBetNames = {"ID giocata", "gioco","importo puntato", "importo vinto", "Data giocata"};
        modelBet = new DefaultTableModel(columnBetNames, 0);
        tableBet = new JTable(modelBet);
        JScrollPane scrollPaneBet = new JScrollPane(tableBet);
        JPanel betPanel = new JPanel(new BorderLayout());
        betPanel.add(new JLabel("Giocate", JLabel.CENTER), BorderLayout.NORTH);
        betPanel.add(scrollPaneBet, BorderLayout.CENTER);

        // pannello tabelle
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new GridLayout(2, 1));  // 2 righe: transazioni sopra, giocate sotto
        tablePanel.add(transPanel);
        tablePanel.add(betPanel);

        add(tablePanel, BorderLayout.CENTER);

        // Pannello per l'inserimento dei dati
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        amountField = new JTextField(10);
        confirmTransactionButton = new JButton("Effettua");

        inputPanel.add(new JLabel("Importo:"));
        inputPanel.add(amountField);
        inputPanel.add(confirmTransactionButton);

        add(inputPanel, BorderLayout.SOUTH);
    }

    // Metodo per aggiungere la transazione alla tabella
    public void addTransaction(Object[] transactionData) {
        modelTransaction.addRow(transactionData);
    }

    public void addBet(Object[] betData) {
        modelBet.addRow(betData);
    }

    public String getAmountField() { return amountField.getText(); }
    public void clearInput() { amountField.setText(""); }

    public JButton getConfirmTransactionButton() {return confirmTransactionButton;}


}
