/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldUsers_Controller;

import controller.LoginController_EJB;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author marlo0212
 */
@Named(value="loginControll")
@SessionScoped
public class LoginController extends LoginController_EJB implements Serializable {
    
}
