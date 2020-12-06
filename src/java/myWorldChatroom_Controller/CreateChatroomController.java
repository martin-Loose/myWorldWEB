/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldChatroom_Controller;

import controller.CreateChatroomController_EJB;
import entities.Chatroom_;
import helperClass.AuthUtil;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;


import javax.inject.Named;


/**
 *
 * @author marlo0212
 */
@Named(value="createChatroom")
@ViewScoped
public class CreateChatroomController extends CreateChatroomController_EJB implements Serializable {
   
  public void prepareChatCreate() throws UnsupportedEncodingException, NoSuchAlgorithmException{
  try{
     
       FacesContext.getCurrentInstance().addMessage(null,
                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Password required", "Password needed")); 
      
  }catch(NullPointerException np){
   FacesContext.getCurrentInstance().addMessage(null,
                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "NullpointerException", "Chatroom created")); 
  }
  
  }
   
}
