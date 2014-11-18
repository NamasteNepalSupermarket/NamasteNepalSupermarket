/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545.waa.nns.model;

//import java.util.List;
//import java.util.Map;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Bishal Timilsina
 */
@Entity
public class Request implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private Customer buyer; 
    @OneToMany(mappedBy="refRequest")
    private List<Product> orderDetails; 
    @OneToOne
    private Address address;
    @OneToOne
    private Shipping shipping;
    @OneToOne
    private Payment payment;

    public Request() {
        orderDetails=new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public List<Product> getOrderDetails() {
        return orderDetails;
    }
    public void setOrderDetails(List<Product> orderDetails) {
        this.orderDetails = orderDetails;
    }
    public Shipping getShipping() {
        return shipping;
    }
    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }
    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    public Customer getBuyer() {
        return buyer;
    }
    public void setBuyer(Customer buyer) {
        this.buyer = buyer;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }         
}