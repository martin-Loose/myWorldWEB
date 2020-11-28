/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldChatroom_Views;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import views.ChatMessagesViews_EJB;

/**
 *
 * @author marlo0212
 */
@Named(value="chatMessageService")
@ViewScoped
public class chatMessagesService extends ChatMessagesViews_EJB implements Serializable{
    
}
