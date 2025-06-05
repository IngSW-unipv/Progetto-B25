package View.Admin;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;


public class AdminCard extends JPanel {

    JLabel NameLabel = new JLabel("Name:");
    JLabel SurnameLabel = new JLabel("Surname:");
    JLabel RoleLabel = new JLabel("Role:");
    JLabel EmailLabel = new JLabel("Email:");
    JLabel PasswordLabel = new JLabel("Password:");
    JLabel IdLabel = new  JLabel("Id:");
    JButton Modify =new JButton("Modify");
    JButton Delete=new JButton("Delete");
    JTextField name = new JTextField();
    JTextField surname = new JTextField();
    JTextField role = new JTextField();
    JTextField email = new JTextField();
    JTextField password = new JTextField();
    JTextField id = new JTextField();
 public  AdminCard() {
     setLayout(new BorderLayout());
     setBackground(Color.BLUE);

     JPanel CardAdminPanel = new JPanel();
     CardAdminPanel.setLayout(new GridLayout(7,1,10,10));
     CardAdminPanel.setBackground(Color.lightGray);
     CardAdminPanel.add(NameLabel);
     CardAdminPanel.add(SurnameLabel);
     CardAdminPanel.add(RoleLabel);
     CardAdminPanel.add(EmailLabel);
     CardAdminPanel.add(PasswordLabel);
     CardAdminPanel.add(IdLabel);
     CardAdminPanel.add(Modify);
     CardAdminPanel.add(Delete);
     CardAdminPanel.add(name);
     CardAdminPanel.add(surname);
     CardAdminPanel.add(role);
     CardAdminPanel.add(email);
     CardAdminPanel.add(password);
     CardAdminPanel.add(id);

 }





}
