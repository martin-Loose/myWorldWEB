/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldChatroom_Views;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import util.AuthenticationUtils;
import views.PrivateChatMessagesViews_EJB;

/**
 *
 * @author marlo0212
 */
@Named(value="privateChatMessagesService")
@ViewScoped
public class PrivateChatMessagesService extends PrivateChatMessagesViews_EJB implements Serializable{

   
 
    public void checkPassword() throws UnsupportedEncodingException, NoSuchAlgorithmException{
     try{
       System.err.println("check password "+getPassword() + " -- "+getSelectedRoom().getName());
       if(getPassword().length()>0){
       setPasswordMatch(getSelectedRoom().getPassword().equals(AuthenticationUtils.encodeSHA256(getPassword())));
       }   
       
      
     }catch(NullPointerException np){
     
     }
        
    }
}
