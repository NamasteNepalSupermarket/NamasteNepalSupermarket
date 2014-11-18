/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545.waa.namastenepalsupermarket.controller;

import com.cs545.waa.namastenepalsupermarket.ejb.CategoryFacadeLocal;
import com.cs545.waa.namastenepalsupermarket.ejb.ProductFacadeLocal;
import com.cs545.waa.namastenepalsupermarket.model.Category;
import com.cs545.waa.namastenepalsupermarket.model.Product;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author gyanu
 */
@Named
@SessionScoped
public class AdminBean implements Serializable {

    private Category category;
    private Product product;
    @EJB
    private CategoryFacadeLocal categoryFacadeLocal;
    @EJB
    private ProductFacadeLocal productFacadeLocal;

    public AdminBean() {
        product=new Product();
        category=new Category();
    }
   
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CategoryFacadeLocal getCategoryFacadeLocal() {
        return categoryFacadeLocal;
    }

    public void setCategoryFacadeLocal(CategoryFacadeLocal categoryFacadeLocal) {
        this.categoryFacadeLocal = categoryFacadeLocal;
    }
    
    //TODO : parent category filtering
    public List<Category> getCategoryList() {
        return categoryFacadeLocal.findAll();
    }

    public ProductFacadeLocal getProductFacadeLocal() {
        return productFacadeLocal;
    }

    public void setProductFacadeLocal(ProductFacadeLocal productFacadeLocal) {
        this.productFacadeLocal = productFacadeLocal;
    }
    
    @TransactionAttribute
    public void saveProduct(){
        System.out.println("inside saveProduct");
        productFacadeLocal.create(product);  
        product=new Product();
    }
    
    @TransactionAttribute
    public void saveCategory(){
        System.out.println("inside saveCategory");
        categoryFacadeLocal.create(category);  
        category=new Category();
    }
    
}
