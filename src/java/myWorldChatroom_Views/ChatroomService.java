/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldChatroom_Views;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import views.ChatroomViews_EJB;

/**
 *
 * @author marlo0212
 */
@Named(value="chatroomService")
@SessionScoped
public class ChatroomService extends ChatroomViews_EJB implements Serializable{
    
}
