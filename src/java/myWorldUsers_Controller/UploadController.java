/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldUsers_Controller;

import controller.upload.UploadController_EJB;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author marlo0212
 */
@Named(value="uploadController")
@SessionScoped
public class UploadController extends UploadController_EJB implements Serializable {
    
}
