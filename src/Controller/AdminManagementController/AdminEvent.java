package Controller.AdminManagementController;
import Model.Admin_Management.Admin;
import Controller.AdminManagementController.SuperAdminEventType;

public class AdminEvent {
    //questo specifica la tipologia di evento avvenuto
    private final SuperAdminEventType type;
    private final Admin admin;
    public AdminEvent(SuperAdminEventType type, Admin admin) {
        this.type = type;
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public SuperAdminEventType getType() {
        return type;
    }

}