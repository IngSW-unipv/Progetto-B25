package Model.Wallet_Payment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Transaction {
    private int transaction_id;
    private int wallett_id;
    private Payment_Type transaction_type;
    private Payment_Method payment_method;
    private String amount;
    private LocalDate card_expiry;
    private LocalDate date_transaction;
    private LocalTime time_transaction;
    private Double pre_currency;
    private Double post_currency;
    private int card_last4;
    private int Admin_id;
//creazione
    public Transaction(int wallett_id, Payment_Type transaction_type, Payment_Method payment_method,LocalDate card_expiry, String amount, Double pre_currency, Double post_currency, int card_last4, int Admin_id) {
        this.wallett_id = wallett_id;
        this.transaction_type = transaction_type;
        this.payment_method = payment_method;
        this.card_expiry = card_expiry;
        this.amount = amount;
        this.pre_currency = pre_currency;
        this.post_currency = post_currency;
        this.card_last4 = card_last4;
        time_transaction=LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        date_transaction=LocalDate.now();
        this.Admin_id = Admin_id;
    }
    //visualizzazione

    public Transaction(int wallett_id, Payment_Type transaction_type, Payment_Method payment_method, String amount, LocalDate card_expiry, int transaction_id, LocalDate date_transaction, LocalDateTime time_transaction, Double post_currency, Double pre_currency, int card_last4, int Admin_id) {
        this.wallett_id = wallett_id;
        this.transaction_type = transaction_type;
        this.payment_method = payment_method;
        this.amount = amount;
        this.card_expiry = card_expiry;
        this.transaction_id = transaction_id;
        this.post_currency = post_currency;
        this.pre_currency = pre_currency;
        this.card_last4 = card_last4;
        this.Admin_id = Admin_id;
    }
}
