package Model.Util;

public abstract class Session {

     private static Session instance; //variabile associata alla classe e non alle sue istanze (in quanto static)

    protected Session() {} //usato pattern singleton

    public static Session getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Sessione non inizializzata");
        }
        return instance;
    }

    // Crea una sessione admin singleton
    public static void createAdminSession(String email) {
        if (instance != null) {
            throw new IllegalStateException("Sessione già aperta");
        }
        instance = new AdminSession(email);
    }

    // Crea una sessione user singleton
    public static void createUserSession(String username) {
        if (instance != null) {
            throw new IllegalStateException("Sessione già aperta");
        }
        instance = new UserSession(username);
    }

    // Cancella la sessione
    public static void clear() {
        instance = null;
    }

    public abstract boolean isAdmin();

    public abstract String getIdentifier();

    // I metodi specifici sono implementati nelle classi derivate
}
