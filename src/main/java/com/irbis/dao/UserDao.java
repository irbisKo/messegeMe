package com.irbis.dao;

/**
 * Created by meta on 06.06.2015.
 */

import com.irbis.models.User;


import java.util.List;

public class UserDao extends BaseDao<User> implements IUserDao{
    public void persist(User entity) {
        getCurrentSession().save(entity);
    }

    public void update(User entity) {
        getCurrentSession().update(entity);
    }

    public User findById(Long id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    public void delete(User entity) {
        getCurrentSession().delete(entity);
    }

    public List<User> findAll() {
        return (List<User>) getCurrentSession().createCriteria(User.class).list();
    }

    public void deleteAll() {
        List<User> users = findAll();
        for (User u : users) {
            delete(u);
        }
    }
}


