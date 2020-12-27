/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.service.GetPath2PicService_EJB;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author marlo0212
 */
@Named(value="getPath2PicService")
@SessionScoped
public class GetPath2PicService extends GetPath2PicService_EJB implements Serializable {
    
}
