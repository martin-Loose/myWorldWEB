/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldBuddieRequests_Controller;

import controller.CreateBuddieRequestController_EJB;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.UsersFacadeLocal;

/**
 *
 * @author marlo0212
 */
@Named(value="createREquestController")
@SessionScoped
public class CreateBuddieRequestController extends CreateBuddieRequestController_EJB implements Serializable {
 
    
}
