package Model.Admin_Management;

import java.time.LocalDate;

public class HelpDesk_Admin extends Admin {
    public HelpDesk_Admin(String name, String surname, String email, String password, AdminRoles role, LocalDate creationDate) {
        super(name, surname, email, password, AdminRoles.HELPDESK_ADMIN, creationDate);
    }
}
