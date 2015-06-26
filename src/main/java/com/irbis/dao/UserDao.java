package com.irbis.dao;

/**
 * Created by meta on 06.06.2015.
 */

import com.irbis.models.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;


import javax.management.Query;
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

   public User find(String name, String password){
       Criteria criteria = getCurrentSession().createCriteria(User.class);
     //  criteria.add(Restrictions.eq("name",name)).uniqueResult();
       criteria.add(Restrictions.eq("password", password)).uniqueResult();

       return (User) criteria.add(Restrictions.eq("name",name)).uniqueResult();
   }

    public boolean findByName(String name){
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        User user =(User) criteria.add(Restrictions.eq("name",name)).uniqueResult();
        if(user == null){
            return false;
        }else {
            if (user.getIduser() != 0)
                return true;
        }
        return false;
    }

    public  boolean findByNamePassword(String name, String password){
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        User user =(User) criteria.add(Restrictions.eq("name",name)).uniqueResult();
    if(user == null){
        return false;
    }else{

        if( user.getPassword().equals(password))

                              return true;
    }
        return false;
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


