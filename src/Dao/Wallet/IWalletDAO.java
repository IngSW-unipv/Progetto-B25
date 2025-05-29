package Dao.Wallet;

import Model.Wallet_Payment.Wallet;

public interface IWalletDAO {
    public boolean createWallet(Wallet wallet);
    public boolean deleteWallet(int wallet_id);
}
