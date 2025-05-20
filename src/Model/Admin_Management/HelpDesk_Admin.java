package Model.Admin_Management;

import java.time.LocalDate;

public class HelpDesk_Admin extends Admin {
    //creazione
    public HelpDesk_Admin(String name, String surname, String email, String password, AdminRoles role) {
        super(name, surname, email, password, AdminRoles.HELPDESK_ADMIN);
    }
    //visualizzazione
    public HelpDesk_Admin(int Admin_id, String name, String surname, String email, String password, AdminRoles role, LocalDate creationDate) {
        super(Admin_id, name, surname, email, password, role, creationDate);
    }
}
