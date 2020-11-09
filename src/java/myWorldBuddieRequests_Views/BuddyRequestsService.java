/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldBuddieRequests_Views;

import entities.Buddyrequests;
import helperclass.myBuddyRequestsHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.BuddyrequestsFacadeLocal;
import jpa.UsersFacadeLocal;
import myWorldUsers_Controller.LoginController;
import views.BuddieRequestsView_EJB;

/**
 *
 * @author marlo0212
 */
@Named(value="requestService")
@SessionScoped
public class BuddyRequestsService extends BuddieRequestsView_EJB implements Serializable{
 @EJB
 private UsersFacadeLocal usersFacade;
 @EJB
 private BuddyrequestsFacadeLocal buddyRequests;
@Inject
private LoginController login;
    

    @Override
    public List<myBuddyRequestsHelper> getAlleREquests() {
       
          List<Buddyrequests>temp=new ArrayList<>();
          List<myBuddyRequestsHelper>allequests=new ArrayList<>();
        try{
            temp=buddyRequests.findByRequesterID(login.getAuthenticatedUser().getId());
            temp.addAll(buddyRequests.findByRequestedID(login.getAuthenticatedUser().getId()));
            
                for(Buddyrequests b:temp){
                myBuddyRequestsHelper tempRequest=new myBuddyRequestsHelper();
                tempRequest.setId(b.getId());
                tempRequest.setRequester(usersFacade.find(b.getRequesterID()).getUsername());
                tempRequest.setRequesterID(usersFacade.find(b.getRequesterID()).getId());
                tempRequest.setRequested(usersFacade.find(b.getRequestedID()).getUsername());
                tempRequest.setRequestED_ID(usersFacade.find(b.getRequestedID()).getId());
                allequests.add(tempRequest);
        }
                return allequests;
        }catch(Exception e){
            System.err.println("error: "+e.getMessage());
        }
        return allequests;
        
    }
 
 
 

}
