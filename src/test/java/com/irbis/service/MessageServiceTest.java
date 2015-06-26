package com.irbis.service;

import com.irbis.models.Messege;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by meta on 26.06.2015.
 */
public class MessageServiceTest {
    MessageService ms = new MessageService();
      Messege m = new Messege();


    @Test
    public void testPersist() throws Exception {
   m.setText("TTTTTTTTTTTTTTTTTTTTEEEEEEXT");
        m.setTitle("Title");
        m.setIdmessage(4);
        m.setIduser(45);

   ms.persist(m);

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {

    }
}