/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldChatroom_Controller;

import controller.ChatCreatePosting_EJB;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author marlo0212
 */
@Named(value="createChatMessageController")
@ViewScoped
public class CreateChatMessageController extends ChatCreatePosting_EJB implements Serializable{
    
}
