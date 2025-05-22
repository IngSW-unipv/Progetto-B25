package Model.Wallet_Payment;
import Model.Admin_Management.Wallet_Admin;
public class Wallet {
    private int wallet_id;
    private int balance;
    private int deposit_limit;
//visualizzazione
    public Wallet(int wallet_id, int balance, int deposit_limit) {
        this.wallet_id = wallet_id;
        this.balance = balance;
        this.deposit_limit = deposit_limit;
    }
    //creazione
    public Wallet(int balance, int deposit_limit) {
        this.balance = balance;
        this.deposit_limit = deposit_limit;
    }
}

