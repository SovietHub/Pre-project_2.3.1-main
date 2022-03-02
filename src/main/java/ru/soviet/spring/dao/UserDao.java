package ru.soviet.spring.dao;

import ru.soviet.spring.models.User;

import java.util.List;

public interface UserDao {

    List<User> index();

    User show(User user);

    void save(User user);

    void update(User updateUser);

    void delete(User user);

}
