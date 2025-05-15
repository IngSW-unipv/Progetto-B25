package Model.Admin_Management;



public class Super_Admin extends Admin {
    public Super_Admin(String name, String surname, String email, String password) {
        super(name,surname , email, password, "Super_Admin");
    }


    public static Admin createAdmin(String name, String surname, String role) {

        return null;
    }

    private static String generateEmail() {
        return "T";
    }

    private static String generatePassword() {
        return "B";
    }
}
