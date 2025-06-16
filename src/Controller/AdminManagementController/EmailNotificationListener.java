package Controller.AdminManagementController;
import Controller.AdminManagementController.AdminEventListener;

public class EmailNotificationListener implements AdminEventListener {
    //LISTENER CONCRETO
    @Override
    public void onEvent(AdminEvent event) {
        switch (event.getType()) {
            case CREATED:

                break;
            case UPDATED:

                break;
            case DELETED:

                break;
        }
    }

}


