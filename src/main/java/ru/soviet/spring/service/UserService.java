package ru.soviet.spring.service;

import ru.soviet.spring.dao.UserDaoImp;
import ru.soviet.spring.models.User;

import java.util.List;

public interface UserService {

    User show(long id);

    void save(User user);

    void update (User updateUser);

    void delete(long id);

    List<User> index();
}
