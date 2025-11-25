package Model.Wallet_Payment;
import Model.Admin_Management.Wallet_Admin;
public class Wallet {
    private int wallet_id;
    private double balance;
    private double deposit_limit;
//visualizzazione
    public Wallet(int wallet_id, double balance, double deposit_limit) {
        this.wallet_id = wallet_id;
        this.balance = balance;
        this.deposit_limit = deposit_limit;
    }
    //creazione
    public Wallet(double balance, double deposit_limit) {
        this.balance = balance;
        this.deposit_limit = deposit_limit;
    }

    public double getDeposit_limit() {
        return deposit_limit;
    }

    public double getBalance() {
        return balance;
    }

    public int getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(int wallet_id) {
        this.wallet_id = wallet_id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDeposit_limit(double deposit_limit) {
        this.deposit_limit = deposit_limit;
    }
}

