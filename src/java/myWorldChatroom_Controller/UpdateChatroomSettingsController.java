/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldChatroom_Controller;

import controller.UpdateChatroomSettingsController_EJB;
import entities.Chatroom;
import helperClass.AuthUtil;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author marlo0212
 */
@Named(value="updateChatroomSettingsController")
@ViewScoped
public class UpdateChatroomSettingsController extends UpdateChatroomSettingsController_EJB implements Serializable {

    @Override
    public void setRoomPassword() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        setPasswordCrypted(AuthUtil.encodeSHA256(getPasswordRoh()));
    }

    
  

    
}
