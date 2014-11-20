/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545.waa.nns.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Bishal Timilsina
 */
@Entity
public class Product implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String image;
    private double price;
    private String model;
    private long quantity;
    private boolean status;
    
    @ManyToOne
    private Request refRequest;
    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Category> categories;

    public Product() {
        categories=new ArrayList<>();
    }

    public Product(String name, String description,String image, double price, String model, long quantity, boolean status, List<Category> categories) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.model = model;
        this.quantity = quantity;
        this.status = status;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public Request getRefRequest() {
        return refRequest;
    }
    public void setRefRequest(Request refRequest) {
        this.refRequest = refRequest;
    }
    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
         
}
