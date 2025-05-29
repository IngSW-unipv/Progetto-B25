package View.Admin;
import javax.swing.*;
import java.awt.*;
import View.Helpdesk.NavigationPanel;
import Model.Admin_Management.Super_Admin;
import Model.Admin_Management.Admin;
public class SuperAdminMainView extends JPanel {
NavigationPanel NavigationBar= new NavigationPanel("Admin", "AllAdmins", "Logout");
public SuperAdminMainView() {
        setLayout(new GridLayout(1,2, 10,10));
        setBackground(Color.WHITE);
        add(NavigationBar);
    }

}
