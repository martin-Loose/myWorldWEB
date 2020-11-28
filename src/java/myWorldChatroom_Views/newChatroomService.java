/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldChatroom_Views;

import entities.Chatroom;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import jpa.ChatroomFacadeLocal;
import views.ChatroomViews_EJB;

/**
 *
 * @author marlo0212
 */
@Named("newChatroomService")
@RequestScoped
public class newChatroomService extends ChatroomViews_EJB {

} 

    