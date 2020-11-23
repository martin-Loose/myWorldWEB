/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldMessages_Controller;

import controller.CreateMessageController_EJB;
import java.io.Serializable;
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
@Named(value="createMessageController")
@SessionScoped
public class CreateMessageController extends CreateMessageController_EJB implements Serializable {
    @EJB
    private UsersFacadeLocal usersFacade;
    @Inject
    private LoginController login;

    @Override
    public void prepareCreateMessage() {
      if(usersFacade.findByName(getReceiver())==null){
           FacesContext.getCurrentInstance().addMessage(null,
                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Receiver not found", "Receiver not exist"));
      }else{
          setMyID(login.getAuthenticatedUser().getId());
          setReceiverID(usersFacade.findByName(getReceiver()).getId());
          send();
          
      } 
    }
    
     @Override
     public String prepareChatRequest(int myID, int receiverID,String chatroomName){
     if(usersFacade.findByName(getReceiver())==null){
           FacesContext.getCurrentInstance().addMessage(null,
                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Receiver not found", "Receiver not exist"));
      }else{
          setMyID(login.getAuthenticatedUser().getId());
          setReceiverID(usersFacade.findByName(getReceiver()).getId());
          setReceiverID(receiverID);
    setTitel(chatroomName);
          send();
          
      } 
     return null;
    
    }
    
}
