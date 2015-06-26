package com.irbis.common;


import com.irbis.models.User;
import com.irbis.service.UserService;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by meta on 05.06.2015.
 */
//@ManagedBean
//@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 11;


    private String username;
    private String password;

    private boolean loggedIn;

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

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

 // @ManagedProperty(value ="#{navigationBean}")
    private NavigationBean navigationBean;


    public String signUp() {
       // System.out.println("Hier ist loginCheck");


        try {
            UserService userService = new UserService();
            if(userService.findByName(username)) {
                FacesContext.getCurrentInstance().addMessage(
                        null, new FacesMessage(FacesMessage.SEVERITY_WARN, "This login is already in use!"
                                , "Please try again!"));
              return  navigationBean.redirectToErrorPage();
            }else {

                User user = new User();

                user.setName(username);
                user.setPassword(password);

                userService.persist(user);


                //        session.save(user);
                //       session.getTransaction().commit();
                System.out.println("Great! User was saved");
                   return navigationBean.redirectToLogin();

            }
        }catch(Throwable ex){
            System.err.println("Failed to create sessionFactory object.bySignUp" + ex);
            throw new ExceptionInInitializerError(ex);
        }


    }
    public String logIn(){

        try{
            UserService userService =new UserService();
          if(userService.findByNamePassword(username, password))
          {

                FacesContext.getCurrentInstance().addMessage(
                        null, new FacesMessage(FacesMessage.SEVERITY_INFO,"User!","username:  "+getUsername()+" userPass:  "+getPassword()+"!")
                );
                 loggedIn =true;

             return navigationBean.toUserProfile();
          //  return navigationBean.redirectToUserProfile();
            }else{
                FacesContext.getCurrentInstance().addMessage(
                        null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Invalid Login!"
                                , "Please try again!")


                );

              loggedIn =false;
            //  return "/error.xhtml";
            return navigationBean.redirectToErrorPage();
              //  return navigationBean.redirectToLogin();
            }



        }catch (Throwable ex){
            System.err.println("Failed to create sessionFactory object.byLogin" + ex);
            throw new ExceptionInInitializerError(ex);

        }
    }
    public String doLogOut(){
        loggedIn =false;
        //Set logout message
        FacesMessage msg = new FacesMessage("Logout success!","INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO); //type of msg

        return "/welcome.xhtml";
    }


    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }
    public NavigationBean getNavigationBean() {
        return navigationBean;
    }

}