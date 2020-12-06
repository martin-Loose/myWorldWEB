/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldChatroom_Views;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import views.PublicChatMessagesViews_EJB;

/**
 *
 * @author marlo0212
 */
@Named(value="publicChatMessageService")
@ViewScoped
public class PublicChatMessagesService extends PublicChatMessagesViews_EJB implements Serializable{
   


}
