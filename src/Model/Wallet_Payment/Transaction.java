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
    private double amount;
    private LocalDate card_expiry;
    private LocalDate date_transaction;
    private LocalTime time_transaction;
    private double pre_currency;
    private double post_currency;
    private int card_last4;
    private int Admin_id;
//creazione
    public Transaction(int wallett_id, Payment_Type transaction_type, Payment_Method payment_method,LocalDate card_expiry, double amount, Double pre_currency, Double post_currency, int card_last4, int Admin_id) {
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

    public Transaction(int wallett_id, Payment_Type transaction_type, Payment_Method payment_method, double amount, LocalDate card_expiry, int transaction_id, LocalDate date_transaction, LocalTime time_transaction, Double post_currency, Double pre_currency, int card_last4, int Admin_id) {
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

    public int getTransaction_id() {
        return transaction_id;
    }

    public int getWallett_id() {
        return wallett_id;
    }

    public Payment_Type getTransaction_type() {
        return transaction_type;
    }

    public Payment_Method getPayment_method() {
        return payment_method;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getCard_expiry() {
        return card_expiry;
    }

    public LocalDate getDate_transaction() {
        return date_transaction;
    }

    public LocalTime getTime_transaction() {
        return time_transaction;
    }

    public Double getPre_currency() {
        return pre_currency;
    }

    public Double getPost_currency() {
        return post_currency;
    }

    public int getCard_last4() {
        return card_last4;
    }

    public int getAdmin_id() {
        return Admin_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public void setWallett_id(int wallett_id) {
        this.wallett_id = wallett_id;
    }

    public void setTransaction_type(Payment_Type transaction_type) {
        this.transaction_type = transaction_type;
    }

    public void setPayment_method(Payment_Method payment_method) {
        this.payment_method = payment_method;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCard_expiry(LocalDate card_expiry) {
        this.card_expiry = card_expiry;
    }

    public void setDate_transaction(LocalDate date_transaction) {
        this.date_transaction = date_transaction;
    }

    public void setTime_transaction(LocalTime time_transaction) {
        this.time_transaction = time_transaction;
    }

    public void setPre_currency(Double pre_currency) {
        this.pre_currency = pre_currency;
    }

    public void setPost_currency(Double post_currency) {
        this.post_currency = post_currency;
    }

    public void setCard_last4(int card_last4) {
        this.card_last4 = card_last4;
    }

    public void setAdmin_id(int admin_id) {
        Admin_id = admin_id;
    }
}
