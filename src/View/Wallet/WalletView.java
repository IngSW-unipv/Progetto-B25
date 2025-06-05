package View.Wallet;

import Model.Wallet_Payment.Wallet;
import Model.Wallet_Payment.Transaction;
import Model.Wallet_Payment.Payment_Method;
import Model.Wallet_Payment.Payment_Type;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class WalletView extends JPanel {

    private JLabel walletIdLabel;
    private JLabel balanceLabel;
    private JLabel depositLimitLabel;
    private JTable transactionTable;
    private JButton sendButton, receiveButton, addFundsButton;

    public WalletView(Wallet wallet, List<Transaction> transactions) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Header: wallet info
        JPanel headerPanel = new JPanel(new GridLayout(3, 1));
        headerPanel.setBackground(new Color(240, 240, 240));

        walletIdLabel = new JLabel("Wallet ID: " + wallet.getWallet_id());
        balanceLabel = new JLabel("Saldo: €" + wallet.getBalance());
        depositLimitLabel = new JLabel("Limite deposito: €" + wallet.getDeposit_limit());

        headerPanel.add(walletIdLabel);
        headerPanel.add(balanceLabel);
        headerPanel.add(depositLimitLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Transaction table
        String[] columns = {"Data", "Ora", "Tipo", "Metodo", "Importo (€)"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        for (Transaction t : transactions) {
            String type = t.getTransaction_type().name();
            String sign = (type.equals("ACCREDITO") || type.equals("RIMBORSO")) ? "+" : "-";
            String rowAmount = sign + "€" + t.getAmount();

            tableModel.addRow(new Object[]{
                    t.getDate_transaction(),
                    t.getTime_transaction(),
                    type,
                    t.getPayment_method().name(),
                    rowAmount
            });
        }

        transactionTable = new JTable(tableModel);
        add(new JScrollPane(transactionTable), BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        sendButton = new JButton("Invia");
        receiveButton = new JButton("Ricevi");
        addFundsButton = new JButton("Aggiungi Fondi");

        buttonPanel.add(sendButton);
        buttonPanel.add(receiveButton);
        buttonPanel.add(addFundsButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Getters per collegare azioni esterne
    public JButton getSendButton() {
        return sendButton;
    }

    public JButton getReceiveButton() {
        return receiveButton;
    }

    public JButton getAddFundsButton() {
        return addFundsButton;
    }

    public JTable getTransactionTable() {
        return transactionTable;
    }
}
