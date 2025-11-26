package View.Util;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class InputErrorAlert {

    // Mappa tra JTextField e JLabel per gli errori
    private final Map<JTextField, JLabel> errorLabels = new HashMap<>();

    /**
     * Registra un JTextField e la JLabel già presente per gli errori.
     * Aggiunge un listener per rimuovere l'errore quando l'utente scrive.
     */
    public void registerField(JTextField field, JLabel errorLabel) {
        errorLabels.put(field, errorLabel);

        // Listener per rimuovere l'errore quando l'utente modifica il campo
        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { clearError(field); }
            @Override
            public void removeUpdate(DocumentEvent e) { clearError(field); }
            @Override
            public void changedUpdate(DocumentEvent e) { clearError(field); }
        });
    }

    /**
     * Mostra un messaggio di errore per un campo specifico.
     */
    public void showError(JTextField field, String message) {
        JLabel label = errorLabels.get(field);
        if (label != null) {
            label.setText(message);
            label.setVisible(true);
        }
    }

    /**
     * Nasconde il messaggio di errore di un campo specifico.
     */
    public void clearError(JTextField field) {
        JLabel label = errorLabels.get(field);
        if (label != null) {
            label.setText("");
            label.setVisible(false);
        }
    }

    /**
     * Nasconde tutti i messaggi di errore registrati.
     */
    public void clearAll() {
        for (JLabel label : errorLabels.values()) {
            label.setText("");
            label.setVisible(false);
        }
    }
}
