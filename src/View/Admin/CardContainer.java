package View.Admin;
import View.Admin.AdminCard;
import javax.swing.*;
import java.awt.*;

public class CardContainer extends JFrame{
    // Pannello che conterrà tutte le card, una sotto l'altra
    private JPanel cardsContainer;
    private JPanel AdminCard;

    // JScrollPane che avvolge cardsContainer
    private JScrollPane scrollPane;
    // ComboBox per scegliere ordinamento data, penso sia figo
    private JComboBox<String> sortCombo;
     public CardContainer() {
         cardsContainer = new JPanel();
         cardsContainer.setLayout(new BoxLayout(cardsContainer, BoxLayout.Y_AXIS));
         cardsContainer.setBackground(new Color(0x2D2D30)); // sfondo scuro leggermente diverso
         cardsContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
         cardsContainer.add(Box.createVerticalGlue());

         scrollPane = new JScrollPane(cardsContainer, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
         scrollPane.getVerticalScrollBar().setUnitIncrement(16); // scroll più fluido


         setLayout(new BorderLayout());
         add(scrollPane, BorderLayout.CENTER);
     }

}


