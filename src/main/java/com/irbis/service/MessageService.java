package com.irbis.service;

import java.util.List;
import com.irbis.dao.MessageDao;
import com.irbis.models.Messege;

/**
 * Created by meta on 26.06.2015.
 */
public class MessageService {
   private static MessageDao messageDao;

    public MessageService()

    {
        messageDao = new MessageDao();
    }

    public void persist(Messege message) {
        messageDao.openCurrentSessionwithTransaction();
        messageDao.persist(message);
        messageDao.closeCurrentSessionwithTransaction();
    }

    public void update(Messege messege) {
        messageDao.openCurrentSessionwithTransaction();
        messageDao.update(messege);
        messageDao.closeCurrentSessionwithTransaction();
    }

    public Messege findById(Long id) {
        messageDao.openCurrentSession();
        Messege Messege = messageDao.findById(id);
        messageDao.closeCurrentSession();
        return Messege;
    }

    public void delete(Long id) {
        messageDao.openCurrentSessionwithTransaction();
        Messege book = messageDao.findById(id);
        messageDao.delete(book);
        messageDao.closeCurrentSessionwithTransaction();
    }

    public List<Messege> findAll() {
        messageDao.openCurrentSession();
        List<Messege> messeges = messageDao.findAll();
        messageDao.closeCurrentSession();
        return messeges;
    }

    public void deleteAll() {
        messageDao.openCurrentSessionwithTransaction();
        messageDao.deleteAll();
        messageDao.closeCurrentSessionwithTransaction();
    }
}
