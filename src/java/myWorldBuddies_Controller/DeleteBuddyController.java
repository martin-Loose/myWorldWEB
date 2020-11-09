/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldBuddies_Controller;

import controller.BuddyDeleteController_EJB;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.UsersFacadeLocal;
import myWorldUsers_Controller.LoginController;

/**
 *
 * @author marlo0212
 */
@Named(value="deleteBuddyController")
@SessionScoped
public class DeleteBuddyController extends BuddyDeleteController_EJB implements Serializable {
 @Inject
 private LoginController login;
 @EJB
 private UsersFacadeLocal usersFacade;

    @Override
    public void prepareBuddyDelete(String buddy) {
        setMyID(login.getAuthenticatedUser().getId());
        setMyBuddyID(usersFacade.findByName(buddy).getId());
        deleteBuddy();
    }
 
 
}
