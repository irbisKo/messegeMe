package com.irbis.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Simple navigation bean
 * @author irrbis
 */
@ManagedBean(name = "navigationBean", eager = true)
@SessionScoped
public class NavigationBean implements Serializable {
    private static final long serialVersionUID = 1520318172495977648L;

    /**
     *   Go to login page.
     *  @return Login page.
     *
     */
    public String toLogin(){
        return "/logIn.xhtml";
    }


    /**
     * Redirect to login page.
     * @return Login page name.
     */
public String redirectToLogin(){
      return "logIn.xhtml?faces-redirect=true";
    }


/**
 *   Go to SignUp page.
  *  @return SignUp page.
*
*/
    public String toSignUp(){
        return "/signUp.xhtml";
    }

    /**
     * Redirect to SignUp page.
     * @return SignUp page name.
     */
     public String redirectToSignUp(){
         return "signUp.xhtml?faces-redirect=true";
     }



    /**
     * Redirect to info page.
     * @return Info page name.
     */
    public String redirectToInfo(){
        return "info.xhtml?faces-redirect=true";
    }
    /**
     * go to info page.
     * @return Info page name.
     */
     public String toInfo(){
         return"/info.xhtml";
     }
    /**
     * redirect to UserProfile page.
     * @return Userprofile page name.
     */

    public String redirectToUserProfile(){
        return "/user/userprofile.xhtml?faces-redirect=true";
    }

    /**
     * Go to to UserProfile page.
     * @return  Userprofil page name.
     */

    public String toUserProfile(){
        return "/user/userprofile.xhtml";
    }

    /**
     * redirect to welcome page.
     * @return Welcome page name.
     */

    public String redirectToWelcome(){
        return "welcome.xhtml?faces-redirect=true";
    }

    /**
     * Go to welcome page.
     * @return Welcome page name.
     */

    public String toWelcome(){
        return "/welcome.xhtml";
    }


    /**
     * redirect to userLocation page.
     * @return userLocation page name.
     */

    public String redirectToUserLocation(){
        return "user/userLocation.xhtml?faces-redirect=true";
    }

    /**
     * Go to userLocation page.
     * @return userLocation page name.
     */

    public String toUserLocation(){
        return "user/userLocation.xhtml";
    }
    /**
     * Go to extendedProfile page.
     * @return userLocation page name.
     */

    public  String toExtendedProfile(){

        return "user/extendedProfile.xhtml";
    }

    /**
     * Redirect to extendedProfile page.
     * @return userLocation page name.
     */

    public  String redirectToExtendedProfile(){

        return "extendedProfile.xhtml?faces-redirect=true";
    }
    /**
     *  Go to ErrorPage page.
     * @return ErrorPage page name.
     */

    public String toErrorPage(){
        return "error.xhtml";
    }
    /**
     * Redirect to ErrorPage page.
     * @return ErrorPage page name.
     */
    public String redirectToErrorPage(){
        return "error.xhtml?faces-redirect=true";
    }

}
