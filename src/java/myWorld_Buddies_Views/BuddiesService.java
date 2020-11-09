/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorld_Buddies_Views;

import entities.Buddies;
import entities.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.UsersFacadeLocal;
import myWorldMessages_Controller.CreateMessageController;
import myWorldUsers_Controller.LoginController;
import views.BuddiesView_EJB;

/**
 *
 * @author marlo0212
 */
@Named(value="buddiesService")
@SessionScoped
public class BuddiesService extends BuddiesView_EJB implements Serializable {
 private Users selectedUser;
 private int receiverID;
    @Inject
    private LoginController login;
@EJB 
private UsersFacadeLocal usersFacadeLocal;
@Inject
private CreateMessageController messageController;
    @Override
    public List<String> getMyBuddies() {
        List<String>myBuddy=new ArrayList<>();
      try{
          List<Buddies>tempList= getBuddiesFacade().findMyBuddies(login.getAuthenticatedUser().getId());
          if(tempList.isEmpty()){
              FacesContext.getCurrentInstance().addMessage("userTable:myBuddies",
                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "No Buddy found", "No Buddy found"));
          }
          tempList.forEach((b) -> {
              myBuddy.add(usersFacadeLocal.find(b.getBuddie2id()).getUsername());
            });
          return myBuddy;
      }catch(Exception e){
          
    }  
      return myBuddy;
    }

    public String prepareMessage(int myID, String receiver){
        setReceiverID(usersFacadeLocal.findByName(receiver).getId());
    messageController.prepareMessage(myID, getReceiverID(), receiver);
       return "/secured/user/messages/messagesIndex?faces-redirect=true";
    }
    public Users getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(String name) {
        try{
             this.selectedUser = usersFacadeLocal.findByName(name);
             setReceiverID(selectedUser.getId());
             System.err.println("selected: "+selectedUser.getEmail());
        }catch(Exception e){
    }
       
    }

    public int getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

   

    
    
    
}
