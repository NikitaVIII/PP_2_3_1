package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    void removeUserById(Long id);

    User getUserById(Long id);

    List<User> getAllUsers();

    void updateUser(User user);
}
