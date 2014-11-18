/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545.waa.nns.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Bishal Timilsina
 */
@Entity
public class Customer extends Person{
    
    @OneToMany(mappedBy="buyer")
    private List<Request> orders; 
    
    public Customer() { 
        orders=new ArrayList<>();
    }
            
    public List<Request> getOrders() {
        return orders;
    }
    public void setOrders(List<Request> orders) {
        this.orders = orders;
    }            
}