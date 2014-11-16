/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545.waa.namastenepalsupermarket;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author gyanu
 */
@Named
@SessionScoped
public class UserBean implements Serializable{
    private String name;

    public UserBean() {
        setName("This is Namaste Nepal Supermarket");
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
