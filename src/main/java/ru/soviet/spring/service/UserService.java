package ru.soviet.spring.service;

import ru.soviet.spring.dao.UserDaoImp;
import ru.soviet.spring.models.User;

public interface UserService {

    User show(int id);

    void save(User user);

    void update (int id, User updateUser);

    void delete(int id);
}
