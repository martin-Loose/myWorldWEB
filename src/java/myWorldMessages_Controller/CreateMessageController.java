/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldMessages_Controller;

import controller.CreateMessageController_EJB;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author marlo0212
 */
@Named(value="createMessageController")
@SessionScoped
public class CreateMessageController extends CreateMessageController_EJB implements Serializable {
    
}
