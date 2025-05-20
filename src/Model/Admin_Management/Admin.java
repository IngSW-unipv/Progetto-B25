package Model.Admin_Management;
import java.time.LocalDate;
public class Admin {
    protected String name;
    protected String surname;
    protected String email;
    protected String password;
    protected LocalDate CreationDate;
    protected AdminRoles role;
    private int Admin_id;

    public Admin(String name, String surname, String email, String password, AdminRoles role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role= role;
        CreationDate=LocalDate.now();
    }
public Admin(int Admin_id, String name, String surname, String email, String password, AdminRoles role, LocalDate creationDate) {
        this.Admin_id = Admin_id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role= role;
        this.CreationDate=creationDate;

}
    public boolean checkPassword(String pass)
    {return password.equals(pass);}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AdminRoles getRole() {
        return role;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setRole(AdminRoles role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        CreationDate = creationDate;
    }

    public int getAdmin_id() {
        return Admin_id;
    }

    public void setAdmin_id(int admin_id) {
        Admin_id = admin_id;
    }

}

