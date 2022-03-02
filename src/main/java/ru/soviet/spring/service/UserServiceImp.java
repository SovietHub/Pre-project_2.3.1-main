package ru.soviet.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import ru.soviet.spring.dao.UserDaoImp;
import ru.soviet.spring.models.User;

import java.util.List;

//@Transactional должна быть в сервисе...так же не вешай ее над read only методами
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDaoImp userDaoImp;

    @Override
    public User show(User user) {
        return userDaoImp.show(user);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDaoImp.save(user);
    }

    @Transactional
    @Override
    public void update(User updateUser) {
        userDaoImp.update(updateUser);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDaoImp.delete(user);
    }

    @Override
    public List index() {
        return userDaoImp.index();
    }
}
