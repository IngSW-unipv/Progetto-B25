package Controller.AdminManagementController;
import Controller.AdminManagementController.AdminEvent;

public interface AdminEventListener {
    // semplice listener che si attiva con la tipologia selezionata e agirà di conseguenza
    void onEvent(AdminEvent event);
}


