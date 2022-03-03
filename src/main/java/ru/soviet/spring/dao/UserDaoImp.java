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
    public User show(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    //удалил передачу по id, оставил одну сущность
    //оставил один merge
    @Override
    public void update(User updateUser){
        entityManager.merge(updateUser);
    }

    @Override
    public void delete(long id) {
        User userDelete = entityManager.find(User.class, id);
        entityManager.remove(userDelete);
    }
}





