/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorld_Chatroom_Controller;

import controller.CreateChatroomController_EJB;
import entities.Chatroom_;
import helperClass.AuthUtil;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author marlo0212
 */
@Named(value="createChatroom")
@SessionScoped
public class CreateChatroomController extends CreateChatroomController_EJB implements Serializable {
   
  public void prepareChatCreate() throws UnsupportedEncodingException, NoSuchAlgorithmException{
  if(getPassword().length()>0){
      setPassword(AuthUtil.encodeSHA256(getPassword()));
      createChatroom();
  }
  }
   
}
