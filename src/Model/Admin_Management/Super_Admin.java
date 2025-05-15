package Model.Admin_Management;



public class Super_Admin extends Admin {
    public Super_Admin(String name, String surname, String email, String password) {
        super(name,surname,email, password, AdminRoles.SUPER_ADMIN);
    }


    public static Admin createAdmin(String name, String surname, String role) {
        String email = generateEmail(name, surname);
        String password = generatePassword();
        switch(role){
            case "Super_Admin":
                return new Super_Admin(name,surname,email,password);
            case "HelpDesk_Admin":
                return new HelpDesk_Admin( name,surname,email,password);
            case "Games_Admin":
                return new Games_Admin(name,surname,email,password);
        };
        return null;
    }

    private static String generateEmail(String name, String surname) {
        return "T";
    }

    private static String generatePassword() {
        return "TributoGormita";
    }
}
