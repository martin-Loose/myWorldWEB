/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldBuddieRequests_Controller;

import controller.BuddyRequestControllerRUD_EJB;
import entities.Users;
import helperclass.myBuddyRequestsHelper;
import java.io.Serializable;
import java.lang.reflect.Field;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.UsersFacadeLocal;
import myWorldUsers_Controller.LoginController;

/**
 *
 * @author marlo0212
 */
@Named(value="acceptBuddyRequest")
@SessionScoped
public class AcceptBuddyRequest_Controller extends BuddyRequestControllerRUD_EJB implements Serializable {
  
   @EJB 
   private UsersFacadeLocal usersFacade; 
 @Inject
 private LoginController login;
/**
 * hand out to EJB
     * @param o
 */
   public void acceptRequest(myBuddyRequestsHelper o){
       int myID=login.getAuthenticatedUser().getId();
       int requestID=o.getId();
       if(o.getRequesterID()==myID){
           FacesContext.getCurrentInstance().addMessage("userTable:acceptRequest",
                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Own request not acceptable", "Accept own request not possible"));
       }else if(o.getRequesterID()!=myID){
           System.err.println("test: "+o.getId() + " myid? "+myID + " requester? "+o.getRequesterID());      
  acceptThisRequest(o.getId(),myID,o.getRequesterID());
       }
    
} 
   
   
}
