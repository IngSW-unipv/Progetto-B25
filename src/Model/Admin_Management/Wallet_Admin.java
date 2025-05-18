package Model.Admin_Management;

import java.time.LocalDate;

public class Wallet_Admin extends Admin {
    public Wallet_Admin(String name, String surname, String email, String password, AdminRoles role, LocalDate creationDate) {
        super(name, surname, email, password, AdminRoles.WALLET_ADMIN, creationDate);
    }
}