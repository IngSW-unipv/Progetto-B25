package Dao.User;

import Model.User_Management.User;
import Model.Util.DBConnection;

import java.sql.*;

public class UserDAO implements IUserDAO {
    private Connection conn;

    public boolean createUser(User user) {
        conn= DBConnection.startConnection(conn);
        PreparedStatement st1; //chiedere a lore

        boolean outcome=true;
        try{
            String query="insert into user(username, password, email, name, surname, Fiscal_Code, birthday, Subcription_date ) values(?,?,?,?,?,?,?, ?)";
            st1=conn.prepareStatement(query);
            st1.setString(1, user.getUsername());
            st1.setString(2, user.getPassword());
            st1.setString(3, user.getEmail());
            st1.setString(4, user.getName());
            st1.setString(5, user.getSurname());
            st1.setString(6, user.getFiscal_Code());
            st1.setDate(7, Date.valueOf(user.getBirthday()));
            st1.setDate(8, Date.valueOf(user.getSubscription_date()));

            int affectedRows=st1.executeUpdate();
            if(affectedRows>0){

                //generazione id da parte del db
                try (ResultSet generatedKeys = st1.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        user.setUser_id(generatedId);
                    }
                }
            }else {
                outcome=false;
            }
        }catch (Exception e){
            e.printStackTrace();
            outcome=false;
        }

        DBConnection.closeConnection(conn);
        return outcome;
    }


    public boolean deleteUser(int user_id) {
        conn= DBConnection.startConnection(conn);
        PreparedStatement st1;
        boolean outcome=true;

        try{
            String query="delete from user where user_id=?";
            st1=conn.prepareStatement(query);
            st1.setInt(1, user_id);
            int affectedRows=st1.executeUpdate();
            if(affectedRows==0){
                outcome=false;
            }
        }catch (Exception e){
            e.printStackTrace();
            outcome=false;
        }
        DBConnection.closeConnection(conn);
        return outcome;

    }
}
