package create_read_update_delete.dao;

import create_read_update_delete.model.User;

import java.util.List;

public interface UserDao {

    public void createTable();

    List<User> getAllUsers();

    void addUser(User user);

    User readUser(long id);

    void updateUser(User user);

    void removeUser(long id);
}
