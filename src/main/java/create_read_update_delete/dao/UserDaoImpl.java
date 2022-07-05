package create_read_update_delete.dao;

import create_read_update_delete.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public void createTable() {
        entityManager.createNativeQuery("create table IF NOT EXISTS spring_hiber.users\n" +
                "(\n" +
                "    id        bigint auto_increment,\n" +
                "    name      varchar(50) null,\n" +
                "    last_name varchar(50) null,\n" +
                "    email     varchar(50) null,\n" +
                "    constraint table_name_pk\n" +
                "        primary key (id)\n" +
                ");");
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public User readUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void removeUser(long id) {
        User user = readUser(id);
        entityManager.remove(user);
    }
}
