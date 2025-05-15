package Model.Admin_Management;

public class Games_Admin extends Admin {
    public Games_Admin(String name, String surname, String email, String password) {
        super(name,surname, email, password, AdminRoles.GAMES_ADMIN);
    }
}
}
