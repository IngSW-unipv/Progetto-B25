package Model.Admin_Management;

import java.time.LocalDate;

public class Games_Admin extends Admin {
    public Games_Admin(int Admin_id, String name, String surname, String email, String password, AdminRoles role, LocalDate creationDate) {
        super(Admin_id, name, surname, email, password, role, creationDate);
    }

    public Games_Admin(String name, String surname, String email, String password, AdminRoles role) {
        super(name, surname, email, password, role);
    }
}