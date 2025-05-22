package Dao.Admin_Management;
import Model.Admin_Management.Admin;

import java.util.ArrayList;

public interface IAdminDAO {
    public boolean createAdmin(Admin admin);
    public boolean deleteAdmin(Admin admin);
    public boolean updateAdmin(Admin admin);
    public Admin selectAdminById(int Admin_id);
    public ArrayList<Admin> selectAllAdmin();

}
