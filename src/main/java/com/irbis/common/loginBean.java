package com.irbis.common;

import com.irbis.dao.UserDao;
import com.irbis.models.User;
import com.irbis.service.UserService;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by meta on 05.06.2015.
 */
@ManagedBean
@SessionScoped
public class loginBean  implements Serializable {

    private static final long serialVersionUID = 11;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;


    public void loginCheckPersistCall() {
       // System.out.println("Hier ist loginCheck");


        try {


            //  Session session = HibernateUtil.getSessionFactory().openSession();

    //    Session session = new Configuration().configure().buildSessionFactory().openSession();
    //        session.beginTransaction();
            User user = new User();

            user.setName(username);
            user.setPassword(password);

            UserService userService =new UserService();
            userService.persist(user);


    //        session.save(user);
     //       session.getTransaction().commit();


            System.out.println("Great! User was saved");
        }catch(Throwable ex){
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }


    }

}