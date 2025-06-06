package View.Admin;
import javax.swing.*;
import java.awt.*;
import View.Helpdesk.NavigationPanel;
import Model.Admin_Management.Super_Admin;
import Model.Admin_Management.Admin;
import View.Admin.CardContainer;
import View.Admin.AdminHomeView;

public class SuperAdminMainView extends JFrame{
    CardContainer cardList;
    AdminHomeView adminHome;
    NavigationPanel NavigationBar= new NavigationPanel("Admin", "AllAdmins", "Home", "Logout" );
    public SuperAdminMainView() {
        setLayout(new GridLayout(1,2, 10,10));
        setBackground(Color.WHITE);
        add(NavigationBar);
    }
    public static void showDefaultView(){};
}
