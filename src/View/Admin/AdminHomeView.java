package View.Admin;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Model.Admin_Management.Admin;
import View.Helpdesk.NavigationPanel;
import View.Admin.AdminCard;

import java.awt.*;


public class AdminHomeView extends JFrame {
    Admin admin;
    NavigationPanel NavigationBar= new NavigationPanel("Admin", "AllAdmins", "Home", "Logout" );



    public AdminHomeView(Admin admin) {
        //qui prendo l'admin e metto la navigation Bar
     this.admin=admin;
     NavigationBar.setVisible(true);

     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2) metto il nome Home al frame principale sotto forma di pannello aggiuntivo
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(255,255,0)); //GIALLO
        header.setPreferredSize(new Dimension(0, 60));
        JLabel titleLabel = new JLabel("HOME", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        header.add(titleLabel, BorderLayout.CENTER);
        add(header, BorderLayout.NORTH);

        // 3)qui intendo metter dati e pure un immagine
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(255,0,0)); // Rosso
        centerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // 3a) Placeholder per eventuale immagine admin, devo capire poi come effettivamente gestire l'immagine per ogni admin
        JPanel imageHolder = new JPanel();
        imageHolder.setPreferredSize(new Dimension(200, 200));
        imageHolder.setMaximumSize(new Dimension(200, 200));
        imageHolder.setBackground(new Color(0xD0D0D0));
        imageHolder.setBorder(new LineBorder(Color.GRAY, 2, true));
        imageHolder.setLayout(new BorderLayout());
        JLabel imgLabel = new JLabel("Immagine Utente", SwingConstants.NORTH);
        imgLabel.setForeground(Color.DARK_GRAY);
        imageHolder.add(imgLabel, BorderLayout.CENTER);

        // mettiamo l'immagine al centro mettendola in un container
        JPanel imgContainer = new JPanel();
        imgContainer.setBackground(centerPanel.getBackground());
        imgContainer.add(imageHolder);
        centerPanel.add(imgContainer);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // 3b) ora dati dell'admin finalmente
        JPanel infoPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        infoPanel.setBackground(centerPanel.getBackground());

        JLabel lblName    = new JLabel("Nome: " + admin.getName());
        JLabel lblSurname = new JLabel("Cognome: " + admin.getSurname());
        JLabel lblEmail   = new JLabel("Email: " + admin.getEmail());
        JLabel lblRole    = new JLabel("Ruolo: " + admin.getRole());
        JLabel lblDate    = new JLabel("Data creazione: " +  admin.getCreationDate().toString());

        //tipo di stile grafico
        Font infoFont = new Font("Goldman", Font.BOLD, 18);
        // metto i font ai label
        lblName.setFont(infoFont);
        lblSurname.setFont(infoFont);
        lblEmail.setFont(infoFont);
        lblRole.setFont(infoFont);
        lblDate.setFont(infoFont);
        //aggungo i pannnelo all'infoPanel
        infoPanel.add(lblName);
        infoPanel.add(lblSurname);
        infoPanel.add(lblEmail);
        infoPanel.add(lblRole);
        infoPanel.add(lblDate);

        // ora mettiamo le info soto l'immagine
        //per fare ciò metto tutte le info in un container
        JPanel infoContainer = new JPanel();
        infoContainer.setLayout(new BoxLayout(infoContainer, BoxLayout.Y_AXIS));
        infoContainer.setBackground(centerPanel.getBackground());

        infoContainer.add(infoPanel);

        centerPanel.add(infoContainer);
       //ora aggiungo immagine e dati nel frame principale
        this.add(centerPanel, BorderLayout.CENTER);
    }


    }





