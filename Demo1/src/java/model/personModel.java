package model;

import controller.personController;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
@ManagedBean(name="personModel")

public class personModel {
    public String username;
    public String password;
    
    public personModel() {
    }
    
    
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

     public String checkValidUser() throws SQLException, ClassNotFoundException
    {
       
        personController p = new personController();
        int sonuc = p.dbQueryConnection(username,password);
        
        if(sonuc==1){
            return "success";
        }
       
        if(sonuc==0 ){

            return "unsuccess";
        }

        
        return null;
        
    }
    
    /**
     * @return the usernameArraylist
     */

 

    }
   


