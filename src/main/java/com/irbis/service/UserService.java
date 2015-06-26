package com.irbis.service;

import com.irbis.dao.UserDao;
import com.irbis.models.User;
import java.util.List;
/**
 * Created by meta on 07.06.2015.
 */
public class UserService {
    private static UserDao userDao;

    public UserService()

    {
        userDao = new UserDao();
    }

    public void persist(User user) {
        userDao.openCurrentSessionwithTransaction();
        userDao.persist(user);
        userDao.closeCurrentSessionwithTransaction();
    }

    public void update(User user) {
        userDao.openCurrentSessionwithTransaction();
        userDao.update(user);
        userDao.closeCurrentSessionwithTransaction();
    }

    public User findById(Long id) {
        userDao.openCurrentSession();
        User user = userDao.findById(id);
        userDao.closeCurrentSession();
        return user;
    }

    public void delete(Long id) {
        userDao.openCurrentSessionwithTransaction();
        User book = userDao.findById(id);
        userDao.delete(book);
        userDao.closeCurrentSessionwithTransaction();
    }

    public List<User> findAll() {
        userDao.openCurrentSession();
        List<User> users = userDao.findAll();
        userDao.closeCurrentSession();
        return users;
    }

    public void deleteAll() {
        userDao.openCurrentSessionwithTransaction();
        userDao.deleteAll();
        userDao.closeCurrentSessionwithTransaction();
    }
    public boolean findByNamePassword(String name, String password) {

        userDao.openCurrentSession();
     boolean isUser = userDao.findByNamePassword(name, password);
        userDao.closeCurrentSession();
        return isUser;
    }


     public boolean findByName(String name){
         userDao.openCurrentSession();
         boolean isUser = userDao.findByName(name);
         userDao.closeCurrentSession();
         return isUser;
     }
    public UserDao getUserDao() {
        return userDao;
    }

}
