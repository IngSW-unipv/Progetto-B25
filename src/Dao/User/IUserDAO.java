package Dao.User;

import Model.User_Management.User;

public interface IUserDAO {
    public boolean createUser(User user);
    public boolean deleteUser(int user_id);
}
