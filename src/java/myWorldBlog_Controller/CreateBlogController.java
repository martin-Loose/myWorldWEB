/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWorldBlog_Controller;


import controller.CreateFileAndFolderController_EJB;
import controller.HoldImageController_EJB;
import entities.Myblog;
import entities.Users;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
import jpa.MyblogFacadeLocal;
import jpa.UsersFacadeLocal;

/**
 *
 * @author marlo0212
 */
@Named(value="createBlogController")
@SessionScoped
public class CreateBlogController implements Serializable {
    private final String UPLOAD__DIRECTORY = "Y:\\upload\\";
    private String subFolder;
    private String username="";
private Part image;
private boolean isJPG;
private boolean isPNG;
private String myblogTitel="";
private String myblogText="";
private final int maxzeichen=400;
private int zeichen=400;
private int creatorID;
private Boolean bolPrivate;
private Boolean bolPublic;
private HoldImageController_EJB holdImage;
    private CreateFileAndFolderController_EJB createFileAndFolder;
@EJB
private UsersFacadeLocal usersFacade;
@EJB
private MyblogFacadeLocal myBlogFacade;

    public CreateBlogController() {
        holdImage = new HoldImageController_EJB();
        createFileAndFolder = new CreateFileAndFolderController_EJB();
    }
public void holdImage(){
try {
            holdImage.setImage(image);
        } catch (Exception e) {
            System.err.println("test error");
        }
}

public String speichern(String username){
    if(holdImage.getImage()==null){
    System.err.println("imgae= null");
    }else{
        doUpload(username, myblogTitel);
    }
    
   setCreatorID(usersFacade.findByName(username).getId());
    Myblog newBlog=new Myblog();
    newBlog.setCreatorID(getCreatorID());
    newBlog.setTitel(myblogTitel);
    newBlog.setMytext(myblogText);
    newBlog.setIsprivate(bolPrivate);
    newBlog.setIspublic(bolPublic);
    newBlog.setMylink("test");
    newBlog.setMypicture(getFilename(holdImage.getImage()));
    newBlog.setId(1);
    Date now=new Date();
    newBlog.setCreatedAt(now);
    myBlogFacade.create(newBlog);
   return "createBlogBeitrag.xhtml";
}
public String doUpload(String username, String folderName) {
        try {
            createFileAndFolder.setUsername(username);
            setUsername(username);
            if (folderName.length() != 0) {
                setSubFolder(folderName);
                createFileAndFolder.setSubFolder(folderName);
                if (createFileAndFolder.isFolderExist() == false) {
                    createFileAndFolder.prepareFolders();
                }
            }
 createFileAndFolder.setFileName(getFilename(holdImage.getImage()));
            createFileAndFolder.setF(createFileAndFolder.uploadString());
            createFileAndFolder.prepareFile();
            holdImage.setImage(image);
            setImage(holdImage.getImage());
            
            
            InputStream in = getImage().getInputStream();
     
            FileOutputStream out = new FileOutputStream(createFileAndFolder.getF());

            byte[] buffer = new byte[1024];
            int length;

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            out.close();
            in.close();
            Users user=new Users();
            user=usersFacade.findByName(username);
            user.setAvatar(getFilename(holdImage.getImage()));
            usersFacade.edit(user);

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
return "userIndex.xhtml?faces-redirect=true";
    }
 /**   public String doPost(String username,String folder) throws ServletException, IOException {
        try{
            if(image.getSize()>0){
            File f=new File(UPLOAD__DIRECTORY+username+"\\Blog\\myblogTitel\\");
        if(!f.exists()){
            f.mkdir();
        }
        Date now=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy|HH:mm:ss");
        f=new File(UPLOAD__DIRECTORY+username+"\\Blog\\myblogTitel\\"+sdf.format(now)+"\\"+getFilename(image));
        if(!f.exists()){
        f.createNewFile();       
      }
        BufferedOutputStream bufferedOutputStream;
                try (InputStream input = new BufferedInputStream(
                        image.getInputStream(),
                        1024 * 1024        /* buffer size */
         /**       )) {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(UPLOAD__DIRECTORY+username+getFilename(image)));
                    byte[] buffer=new byte[1024*1024];
                    int length;
                    while((length=input.read(buffer))>0){
                        bufferedOutputStream.write(buffer, 0, length);
                        
                    }   }
            bufferedOutputStream.close();
            }
        
       }catch(Exception e){
           System.err.println("error: "+e.getMessage());
       }
    
        return "createBlogBeitrag.xhtml";
    }
 **/

    private static String getFilename(Part part) {
        String uploadName = "";
        if (part.getSubmittedFileName().contains("\\")) {
            uploadName = "" + part.getSubmittedFileName().subSequence(part.getSubmittedFileName().lastIndexOf("\\") + 1,
                    part.getSubmittedFileName().length());
            return uploadName;
        } else {
            return part.getSubmittedFileName();
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }

    public boolean isIsJPG() {
       return image.getSubmittedFileName().subSequence
        (image.getSubmittedFileName().length()-4,
                image.getSubmittedFileName().length())
               .toString().equalsIgnoreCase("jpg");
       
        
    }

    public void setIsJPG(boolean isJPG) {
        this.isJPG = isJPG;
    }

    public boolean isIsPNG() {
        return isPNG;
    }

    public void setIsPNG(boolean isPNG) {
        this.isPNG = isPNG;
    }

    public String getMyblogTitel() {
        return myblogTitel;
    }

    public void setMyblogTitel(String myblogTitel) {
        this.myblogTitel = myblogTitel;
    }

    public String getMyblogText() {
        return myblogText;
    }

    public void setMyblogText(String myblogText) {
        this.myblogText = myblogText;
    }
public void test(){
    setZeichen(maxzeichen-myblogText.length());
}

    public int getZeichen() {
        return zeichen;
    }

    public void setZeichen(int zeichen) {
        this.zeichen = zeichen;
    }

    public int getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
    }

    public Boolean getBolPrivate() {
        return bolPrivate;
    }

    public void setBolPrivate(Boolean bolPrivate) {
        this.bolPrivate = bolPrivate;
    }

    public Boolean getBolPublic() {
        return bolPublic;
    }

    public void setBolPublic(Boolean bolPublic) {
        this.bolPublic = bolPublic;
    }

    public String getSubFolder() {
        return subFolder;
    }

    public void setSubFolder(String subFolder) {
        this.subFolder = subFolder;
    }
   
}
