package Model.Util;

class UserSession extends Session {

    private final String username; //il valore deve rimanere costante per tutta la durata della sessione

    public UserSession(String username) {
        this.username = username;
    }

    @Override
    public boolean isAdmin() {
        return false;
    }

    @Override
    public String getIdentifier()  {
        return username;
    }
}
