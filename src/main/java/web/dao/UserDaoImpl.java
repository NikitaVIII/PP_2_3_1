package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

//    public UserDaoImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(Long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public User getUserById(Long id) {
       return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
