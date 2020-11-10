/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldUsers_Views;

import entities.Users;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.UsersFacadeLocal;
import views.UsersViewService_EJB;


/**
 *
 * @author marlo0212
 */
@Named(value="userService")
@SessionScoped
public class UserService extends UsersViewService_EJB implements Serializable {
 private String selectedUserString;
    @EJB
  private UsersFacadeLocal usersFacadeLocal;

    public String getSelectedUserString() {
        return selectedUserString;
    }

    public String setSelectedUserString(String name){
    try{
        setSelectedUser(usersFacadeLocal.findByName(name));
    return "/secured/user/users/userDetails?faces-redirect=true";
    }catch(Exception e){
    }
    return null;
    }
  
    
    
}
