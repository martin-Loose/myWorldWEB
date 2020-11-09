/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldUsers_Controller;

import controller.CreateUserController_EJB;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author marlo0212
 */
@Named(value="createUser")
@SessionScoped
public class CreateUserController extends CreateUserController_EJB implements Serializable{
    
}
