package Dao.Wallet;

import Model.Util.DBConnection;
import Model.Wallet_Payment.Transaction;


import java.sql.*;

public class TransactionDao implements ITransactionDAO {
    private Connection conn;

    public boolean createTransaction(Transaction transaction) {
        conn = DBConnection.startConnection(conn);
        PreparedStatement st1;

        boolean outcome = true;
        try {
            String query = "insert into transaction(transaction_type, payment_method, amount,card_expiry, date_transaction, time_transaction, pre_currency, post_currency, card_last4) values(?,?,?,?,?,?,?,?,?) ";
            st1 = conn.prepareStatement(query);
            st1.setString(1, transaction.getTransaction_type().name());
            st1.setString(2, transaction.getPayment_method().name());
            st1.setInt(3, transaction.getAmount());
            st1.setDate(4, Date.valueOf(transaction.getCard_expiry()));
            st1.setDate(5, Date.valueOf(transaction.getDate_transaction()));
            st1.setTime(6, Time.valueOf(transaction.getTime_transaction()));
            st1.setDouble(7, transaction.getPre_currency());
            st1.setDouble(8, transaction.getPost_currency());
            st1.setInt(9, transaction.getCard_last4());

            int affectedRows = st1.executeUpdate();
            if (affectedRows > 0) {

                //generazione id da parte del db
                try (ResultSet generatedKeys = st1.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        transaction.setTransaction_id(generatedId);
                    }
                }
            } else {
                outcome = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            outcome = false;
        }

        DBConnection.closeConnection(conn);
        return outcome;
    }

    public boolean deleteTransaction(int transaction_id) {
        conn = DBConnection.startConnection(conn);
        PreparedStatement st1;
        boolean outcome = true;

        try {
            String query = "delete from transaction where Transaction_id=?";
            st1 = conn.prepareStatement(query);
            st1.setInt(1, transaction_id);
            int affectedRows = st1.executeUpdate();
            if (affectedRows == 0) {
                outcome = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            outcome = false;
        }
        DBConnection.closeConnection(conn);
        return outcome;

    }
}