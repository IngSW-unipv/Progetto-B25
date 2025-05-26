package Model.Admin_Management;

import Model.Games_Storage.Game;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Games_Admin extends Admin {
    private static List<Game> games = new ArrayList<>();

    public Games_Admin(int Admin_id, String name, String surname, String email, String password, AdminRoles role, LocalDate creationDate) {
        super(Admin_id, name, surname, email, password, role, creationDate);
    }

    public Games_Admin(String name, String surname, String email, String password, AdminRoles role) {
        super(name, surname, email, password, role);
    }
// inserimento gamesManager superfluo


}