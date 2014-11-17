/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545.waa.namastenepalsupermarket.model;

//import java.util.List;
//import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Bishal Timilsina
 */
@Entity
public class Request {

    @Id
    @GeneratedValue
    private Long id;
//    private List<Product> orderDetails; 
//    private Shipping shipping;
//    private Payment payment;

    public Request() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
//    public List<Product> getOrderDetails() {
//        return orderDetails;
//    }
//    public void setOrderDetails(List<Product> orderDetails) {
//        this.orderDetails = orderDetails;
//    }
//    public Shipping getShipping() {
//        return shipping;
//    }
//    public void setShipping(Shipping shipping) {
//        this.shipping = shipping;
//    }
//    public Payment getPayment() {
//        return payment;
//    }
//    public void setPayment(Payment payment) {
//        this.payment = payment;
//    }

}
