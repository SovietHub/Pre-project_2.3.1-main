package ru.soviet.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import ru.soviet.spring.dao.UserDaoImp;
import ru.soviet.spring.models.User;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDaoImp userDaoImp;

    @Override
    public User show(int id) {
        return userDaoImp.show(id);
    }

    @Override
    public void save(User user) {
        userDaoImp.save(user);
    }

    @Override
    public void update(int id, User updateUser) {
        userDaoImp.update(id, updateUser);
    }

    @Override
    public void delete(int id) {
        userDaoImp.delete(id);
    }
}
