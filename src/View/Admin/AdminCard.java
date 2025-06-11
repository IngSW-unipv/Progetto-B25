package View.Admin;
import Model.Admin_Management.Admin;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;


public class AdminCard extends JPanel {


    private JPanel AdminCard(Admin admin) {
        // 1. Creo un nuovo JPanel che sarà la card, con BorderLayout
        JPanel card = new JPanel(new BorderLayout());
        card.setPreferredSize(new Dimension(520, 120));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        card.setBackground(new Color(0x3E3E42));

        card.setBorder(new CompoundBorder(
                new LineBorder(new Color(0xFF6A00), 2, true),  // bordo arrotondato arancione
                new EmptyBorder(8, 12, 8, 12)));                 // padding interno

        // 2. Costruisco textPanel (5 righe, una per ogni JLabel)
        JPanel textPanel = new JPanel(new GridLayout(5, 1));
        textPanel.setOpaque(false);  // trasparente, così si vede lo sfondo della card
        JLabel lblName    = new JLabel("Nome: " + admin.getName());
        JLabel lblSurname = new JLabel("Cognome: " + admin.getSurname());
        JLabel lblEmail   = new JLabel("Email: " + admin.getEmail());
        JLabel lblPass    = new JLabel("Password: " + admin.getPassword());
        JLabel lblDate    = new JLabel("Data creazione: " + admin.getCreationDate().toString());
        // Imposto i colori dei testi
        lblName.setForeground(Color.WHITE);
        lblSurname.setForeground(Color.WHITE);
        lblEmail.setForeground(Color.WHITE);
        lblPass.setForeground(Color.ORANGE);
        lblDate.setForeground(Color.LIGHT_GRAY);
        // Aggiungo le label a textPanel
        textPanel.add(lblName);
        textPanel.add(lblSurname);
        textPanel.add(lblEmail);
        textPanel.add(lblPass);
        textPanel.add(lblDate);

        // 3. Costruisco btnPanel (BoxLayout verticale per i pulsanti)
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
        btnPanel.setOpaque(false);
        JButton btnEdit = new JButton("Modifica");
        btnEdit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEdit.setMaximumSize(new Dimension(100, 30));
        // Listener fittizio per “Modifica”
        btnPanel.add(btnEdit);
        btnPanel.add(Box.createRigidArea(new Dimension(0, 8)));
        JButton btnDelete = new JButton("Elimina");
        btnDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDelete.setMaximumSize(new Dimension(100, 30));

        btnPanel.add(btnDelete);

        // 4. Inserisco i due pannelli (textPanel e btnPanel) nella card
        card.add(textPanel, BorderLayout.CENTER);
        card.add(btnPanel, BorderLayout.EAST);

        return card;
    }






}
