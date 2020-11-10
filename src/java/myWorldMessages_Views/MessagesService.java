/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldMessages_Views;

import entities.Messages;
import helperClass.MessagesSenderHelperClass;
import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.UsersFacadeLocal;
import myWorldUsers_Controller.LoginController;
import views.MessageViews_EJB;

/**
 *
 * @author marlo0212
 */
@Named(value="messageService")
@SessionScoped
public class MessagesService extends MessageViews_EJB implements Serializable{
@Inject
private LoginController login;
@EJB
private UsersFacadeLocal usersFacade;

    @Override
    public int getInbox() {
        getLstInbox(login.getAuthenticatedUser().getId());
        return getMyList().size();
    }


    @Override
    public List<MessagesSenderHelperClass> getMyList() {
       List<MessagesSenderHelperClass>myList=new ArrayList<>();
        try{
        for(Messages m: getLstInbox(login.getAuthenticatedUser().getId())){
            MessagesSenderHelperClass helper=new MessagesSenderHelperClass();
        helper=new MessagesSenderHelperClass();
        helper.setMessageID(m.getId());
        helper.setSender(usersFacade.find(m.getSenderID()).getUsername());
            setAbsender(usersFacade.find(m.getSenderID()).getUsername());
        helper.setTitle(m.getBetreff());
        helper.setSendDate(m.getWann());
        myList.add(helper);
        }
        }catch(NullPointerException n){
        
        }
        return myList;
    }

    
 
    public String convertTime(long time){
    Date date = new Date(time);
    Format format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    return format.format(date);
}
    
}
