package Model.Admin_Management;


import java.time.LocalDate;

public class Super_Admin extends Admin {
    public Super_Admin(int Admin_id, String name, String surname, String email, String password, AdminRoles role, LocalDate creationDate) {
        super(Admin_id, name, surname, email, password, role, creationDate);
    }

    public Super_Admin(String name, String surname, String email, String password, AdminRoles role) {
        super(name, surname, email, password, role);
    }

    public static Admin createAdmin(String name, String surname, String role) {
            String email = generateEmail();
            String password = generatePassword(name, surname);
            switch(role){
                case "SUPER_ADMIN":
                    return new Super_Admin( name,surname, email,  password, AdminRoles.SUPER_ADMIN);
                case "HELPDESK_ADMIN":
                    return new HelpDesk_Admin( name,  surname,  email,  password,  AdminRoles.HELPDESK_ADMIN);
                case "GAMES_ADMIN":
                    return new Games_Admin(name, surname, email, password, AdminRoles.GAMES_ADMIN);
                case "TOURNAMENT_ADMIN":
                    return new Tournament_Admin(name, surname, email, password, AdminRoles.TOURNAMENT_ADMIN );
                case "WALLET_ADMIN":
                    return new Wallet_Admin(name, surname, email, password, AdminRoles.WALLET_ADMIN);
                default: return null;
            }

    }

    private static String generateEmail() {
        String alphabet= "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        int alphabethLength = alphabet.length();
        String password = "";
        int passwordLength = 6;
        for(int i = 0; i < passwordLength; i++){
            int randomIndex = (int)(Math.random()*alphabethLength);
            password += alphabet.charAt(randomIndex);
        }
        return password;
    }

    private static String generatePassword(String name, String surname) {
        return name.toLowerCase() + "." + surname.toLowerCase() + "01@gmail.com";
     //in caso ci siano due persone con stesso nome e cognome, devo ancora pensarci
    }
}
