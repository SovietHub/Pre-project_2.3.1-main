package ru.soviet.spring.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;

import ru.soviet.spring.models.User;
import java.util.List;
import javax.persistence.EntityManager;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Query(nativeQuery = true)
    public List index() {
        return entityManager.createQuery("from User")
                .getResultList();
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User updateUser) {
        User userBeingUpdated = show(id);

        userBeingUpdated.setName(updateUser.getName());
        userBeingUpdated.setAge(updateUser.getAge());
        entityManager.merge(userBeingUpdated);
    }

    @Override
    public void delete(int id) {
        User userDelete = entityManager.find(User.class, id);
        entityManager.remove(userDelete);
    }
}





