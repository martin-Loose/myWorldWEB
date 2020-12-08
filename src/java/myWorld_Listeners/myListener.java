/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorld_Listeners;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author marlo0212
 */
@WebListener

public class myListener implements HttpSessionListener{

    private List<String> sessions = new ArrayList<>();
    public static final String COUNTER = "session-counter";

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("SessionCounter.sessionCreated");
        HttpSession session = event.getSession();
        
        sessions.add(session.getId());
        session.setAttribute(myListener.COUNTER, this);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("SessionCounter.sessionDestroyed");
        HttpSession session = event.getSession();
        sessions.remove(session.getId());
        session.setAttribute(myListener.COUNTER, this);
    }

    public int getActiveSessionNumber() {
        return sessions.size();
    }
    
}
