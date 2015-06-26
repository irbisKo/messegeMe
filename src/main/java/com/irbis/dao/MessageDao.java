package com.irbis.dao;

import com.irbis.models.Messege;

import java.util.List;

/**
 * Created by meta on 26.06.2015.
 */
public class MessageDao extends BaseDao<Messege> implements IMessageDao {

    public void persist(Messege entity) {
        getCurrentSession().save(entity);

    }

    public void update(Messege entity) {
        getCurrentSession().update(entity);
    }

    public Messege findById(Long id) {
        return (Messege) getCurrentSession().get(Messege.class, id);
    }

    public void delete(Messege entity) {
        getCurrentSession().delete(entity);
    }
/*
    public Messege findByTitle( String title){

        return
    }

    */
    public List<Messege> findAll() {
        return null;
    }

    public void deleteAll() {

    }
}
