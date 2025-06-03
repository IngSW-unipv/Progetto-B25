package Model.Util;

class AdminSession extends Session {

    private final String email; //il valore deve rimanere costante per tutta la durata della sessione

    public AdminSession(String email) {
        this.email = email;
    }

    @Override
    public boolean isAdmin() {
        return true;
    }

    public String getEmail() {
        return email;
    }
}
