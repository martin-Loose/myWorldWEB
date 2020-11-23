/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldChatroom_Controller;

import controller.ChatCreatePosting_EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author marlo0212
 */
@Named(value="createChatMessageController")
@RequestScoped
public class CreateChatMessageController extends ChatCreatePosting_EJB{
    
}
