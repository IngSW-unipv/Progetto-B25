package Model.Admin_Management;

import java.time.LocalDate;

public class Games_Admin extends Admin {
    public Games_Admin(String name, String surname, String email, String password, AdminRoles role, LocalDate creationDate) {
        super(name, surname, email, password, AdminRoles.GAMES_ADMIN, creationDate);
    }
}