package Dao.Wallet;

import Model.Wallet_Payment.Transaction;

public interface ITransactionDAO {
    public boolean createTransaction(Transaction transaction);
    public boolean deleteTransaction(int transaction_id);
}
