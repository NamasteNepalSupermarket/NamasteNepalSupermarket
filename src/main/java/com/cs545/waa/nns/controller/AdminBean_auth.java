/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545.waa.nns.controller;

import com.cs544.waa.nns.util.MD5encrypt;
import com.cs545.waa.nns.ejb.AdminFacadeLocal;
import com.cs545.waa.nns.model.Admin;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;

/**
 *
 * @author Bishal Timilsina
 */
    @Named
    @SessionScoped
    public class AdminBean_auth implements Serializable {
    private Admin admin;    
    private String authStr="Log In";
    
    @EJB
    private AdminFacadeLocal adminFacadeLocal;

    public String getAuthStr() {
        return authStr;
    }

    public void setAuthStr(String authStr) {
        this.authStr = authStr;
    }
        
    public AdminBean_auth() {        
        admin=new Admin();
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public AdminFacadeLocal getAdminFacadeLocal() {
        return adminFacadeLocal;
    }

    public void setAdminFacadeLocal(AdminFacadeLocal adminFacadeLocal) {
        this.adminFacadeLocal = adminFacadeLocal;
    }
             
    public List<Admin> getAdminList(){
        return adminFacadeLocal.findAll();
    }
    
    public void checkLogIn(ComponentSystemEvent event) {     
     if(isInvalid()){
        FacesContext context = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();
        handler.performNavigation("login");
     }
    } 

    public String showInxPage(){
        String nextPage="index";
        if(isInvalid())
            nextPage="login";
        return nextPage;
    }

    private boolean isInvalid(){        
        System.out.println(admin.getUsername());
        if(admin.getPassword()!=null){
            try {
                System.out.println(MD5encrypt.getCipher(admin.getPassword()));
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(com.cs545.waa.nns.controller.AdminBean_auth.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        boolean invalid=true;
        if(admin.getUsername()!=null && admin.getPassword()!=null){
            for(Admin a:getAdminList()){
                try {
                    System.out.println(a.getUsername()+":"+a.getPassword());
                    if(admin.getUsername().equals(a.getUsername()) && MD5encrypt.getCipher(admin.getPassword()).equals(a.getPassword())){
                        authStr="Log Out";
                        invalid=false;
                        break;                
                    }
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(com.cs545.waa.nns.controller.AdminBean_auth.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }        
        return invalid;
    }
    
    public String flush(){
        if(authStr.equals("Log Out")){
            admin.setUsername("");
            admin.setPassword("");
            authStr="Log In";
        }
        return "login";
    }
}