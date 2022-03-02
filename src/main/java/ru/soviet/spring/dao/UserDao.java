package ru.soviet.spring.dao;

import ru.soviet.spring.models.User;

import java.util.List;

public interface UserDao {

    List<User> index();

    User show(int id);

    void save(User user);

    void update(int id, User updateUser);

    void delete(int id);

}
