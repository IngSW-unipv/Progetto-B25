package Dao.Admin_Management;

import java.sql.*;
import java.util.ArrayList;

import Model.Admin_Management.Admin;
import Model.Admin_Management.AdminRoles;
import Model.Helpdesk.StateTicket;
import Model.Helpdesk.Ticket;
import Model.Util.DBConnection;
import java.sql.*;



public class AdminDAO implements IAdminDAO {

    private Connection conn;

    @Override
    public boolean createAdmin(Admin admin) {
        conn = DBConnection.startConnection(conn);
        PreparedStatement st;
        boolean outcome = true;
        try {
            String query = "INSERT INTO ADMIN (name, surname,email, password, CreationDate, role) VALUES (?, ?, ?, ?, ?, ?)";
            st = conn.prepareStatement(query);
            st.setString(1, admin.getName());
            st.setString(2, admin.getSurname());
            st.setString(3, admin.getEmail());
            st.setString(4, admin.getPassword());
            st.setDate(5, Date.valueOf(admin.getCreationDate()));
            st.setString(6, admin.getRole().name());

            int affectedRows = st.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        admin.setAdmin_id(generatedId);
                    }
                }
            } else {
                outcome = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            outcome = false;
        } finally {
            DBConnection.closeConnection(conn);
        }
        return outcome;
    }

    @Override
    public boolean deleteAdmin(Admin admin) {
        conn = DBConnection.startConnection(conn);
        PreparedStatement st;
        boolean outcome = true;
        try {
            String query = "DELETE FROM ADMIN WHERE ADMIN_ID = ?";
            st = conn.prepareStatement(query);
            st.setInt(1, admin.getAdmin_id());
            int affectedRows = st.executeUpdate();
            if (affectedRows == 0) {
                outcome = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            outcome = false;
        } finally {
            DBConnection.closeConnection(conn);
        }
        return outcome;
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        conn = DBConnection.startConnection(conn);
        PreparedStatement st;
        boolean outcome = true;
        try {
            String query = "UPDATE ADMIN SET Admin_id= ?, NAME = ?, SURNAME = ?, EMAIL= ?, PASSWORD = ?, ROLE= ? , CREATIONDATE= ? WHERE Admin_id = ?";
            st = conn.prepareStatement(query);
            st.setInt(1, admin.getAdmin_id());
            st.setString(2, admin.getName());
            st.setString(3, admin.getSurname());
            st.setString(4, admin.getEmail());
            st.setString(5, admin.getPassword());
            st.setString(6, admin.getRole().name());
            st.setDate(7, Date.valueOf(admin.getCreationDate()));

            int affectedRows = st.executeUpdate();
            if (affectedRows == 0) {
                outcome = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            outcome = false;
        } finally {
            DBConnection.closeConnection(conn);
        }
        return outcome;
    }

    @Override
    public Admin selectAdminById(int adminId) {
        conn = DBConnection.startConnection(conn);
        PreparedStatement st;
        ResultSet rs;
        Admin admin = null;
        try {
            String query = "SELECT * FROM ADMIN WHERE ADMIN_ID = ?";
            st = conn.prepareStatement(query);
            st.setInt(1, adminId);
            rs = st.executeQuery();
            while(rs.next())
            {
                admin= new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)
                    , rs.getString(5), AdminRoles.valueOf(rs.getString(6)), rs.getDate(7).toLocalDate());

            }
        }catch (Exception e){e.printStackTrace();}

        DBConnection.closeConnection(conn);

        return admin;
    }

    @Override
    public ArrayList<Admin> selectAllAdmin() {
        ArrayList<Admin> result = new ArrayList<>();
        conn = DBConnection.startConnection(conn);
        Statement st;
        ResultSet rs;
        try {
            String query = "SELECT * FROM ADMIN";
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Admin admin = new Admin(
                        rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)
                        , rs.getString(5), AdminRoles.valueOf(rs.getString(6)), rs.getDate(7).toLocalDate()
                );
                result.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(conn);
        }
        return result;
    }
}

