package View.Admin;
import Model.Admin_Management.Admin;
import View.Admin.AdminCard;
import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.List;

import View.Helpdesk.NavigationPanel;

public class CardContainer extends JPanel{
    private JPanel cardsContainer;
    private JScrollPane scrollPane;
    private JComboBox<String> sortCombo;
    private NavigationPanel NavigationBar=new NavigationPanel("Admin", "AllAdmins", "Home", "Logout");
CardContainer() {
    // 1) Pannello in alto per ordinamento
    JPanel topControls = new JPanel(new FlowLayout(FlowLayout.LEFT));
    topControls.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


    // 2) cardsContainer: BoxLayout verticale
    cardsContainer = new JPanel();
    cardsContainer.setLayout(new BoxLayout(cardsContainer, BoxLayout.Y_AXIS));
    cardsContainer.setBackground(new Color(0x2D2D30));
    cardsContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    cardsContainer.add(Box.createVerticalGlue());

    // 3) JScrollPane per lo scrolling verticale
    scrollPane = new JScrollPane(cardsContainer,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.getVerticalScrollBar().setUnitIncrement(16);

    // 4) Layout generale
    setLayout(new BorderLayout());
    add(topControls, BorderLayout.NORTH);
    add(scrollPane, BorderLayout.CENTER);
}


    // Carica la lista di admin e aggiorna le card
    private void loadAdminsAndRefresh() {
    // questa è la futura lista di admin che prenderò dal DB
        List<Admin> admins = List.of();

        // Rimuove eventuali card vecchie
        cardsContainer.removeAll();

        // Ricrea le card per ogni admin
        for (Admin a : admins) {
            JPanel card =  new AdminCard();
            cardsContainer.add(card);
            cardsContainer.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        // Riempi sotto con glue per “spingere” verso l’alto
        cardsContainer.add(Box.createVerticalGlue());

        cardsContainer.revalidate();
        cardsContainer.repaint();
    }
}




