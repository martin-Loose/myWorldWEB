/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldBlog_Views;

import controller.BlogService_EJB;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.UsersFacadeLocal;

/**
 *
 * @author marlo0212
 */
@Named(value="blogService")
@SessionScoped
public class myWorldBlogView extends BlogService_EJB implements Serializable{
    private String poster;
    @EJB
    private UsersFacadeLocal usersFacadeLocal;
 
    public void doJob(int id){
   setPoster(usersFacadeLocal.find(id).getUsername());
       System.err.println("test");
   }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String test) {
        this.poster = test;
    }

    
 
 
}
