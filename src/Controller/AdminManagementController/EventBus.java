package Controller.AdminManagementController;

import java.util.ArrayList;
import java.util.List;

public class EventBus {
    private static final EventBus INSTANCE = new EventBus();
    private final List<AdminEventListener> listeners = new ArrayList<>();

    private EventBus() {
    }

    public static EventBus getInstance() {
        return INSTANCE;
    }
    // Registra (tramite register) chi vuole ricevere eventi.
    //Inoltra (tramite publish) ogni AdminEvent a tutti i listener.
    //ciò in linea di massima ma non ne sono sicuro, però sono sulla buona strada quindi lascio
//    public void register(AdminEventListener lstn) { listeners.add(lstn); }
//    public void publish(AdminEvent evt) {
//        for (var lstn : listeners) {
//            try {
//                lstn.onEvent(evt);
//            } catch (Exception e) {
//                e.printStackTrace();
//
//            }
//        }
//    }
}
