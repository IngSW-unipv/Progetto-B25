package Model.Admin_Management;

import java.time.LocalDate;

public class Tournament_Admin extends Admin {
    public Tournament_Admin(String name, String surname, String email, String password, AdminRoles role, LocalDate creationDate) {
        super(name, surname, email, password, AdminRoles.TOURNAMENT_ADMIN, creationDate);
    }
}