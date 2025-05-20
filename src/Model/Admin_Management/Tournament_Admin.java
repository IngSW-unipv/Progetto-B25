package Model.Admin_Management;

import java.time.LocalDate;

public class Tournament_Admin extends Admin {
    public Tournament_Admin(int Admin_id, String name, String surname, String email, String password,  LocalDate creationDate) {
        super(Admin_id, name, surname, email, password, creationDate, AdminRoles.TOURNAMENT_ADMIN);
    }

    public Tournament_Admin(String name, String surname, String email, String password, AdminRoles role) {
        super(name, surname, email, password, AdminRoles.TOURNAMENT_ADMIN);
    }
}