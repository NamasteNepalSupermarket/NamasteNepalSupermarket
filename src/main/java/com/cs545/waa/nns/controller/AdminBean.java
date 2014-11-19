/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545.waa.nns.controller;

import com.cs544.waa.nns.util.MD5encrypt;
import com.cs544.waa.nns.util.Utility;
import com.cs545.waa.nns.ejb.AdminFacadeLocal;
import com.cs545.waa.nns.ejb.CategoryFacadeLocal;
import com.cs545.waa.nns.ejb.ProductFacadeLocal;
import com.cs545.waa.nns.model.Admin;
import com.cs545.waa.nns.model.Category;
import com.cs545.waa.nns.model.Product;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;

/**
 *
 * @author gyanu
 */
@Named
@SessionScoped
public class AdminBean implements Serializable {
    private Admin admin;
    private Category category;
    private Product product;
    private String authStr="Log In";
    @EJB
    private CategoryFacadeLocal categoryFacadeLocal;

    @EJB
    private ProductFacadeLocal productFacadeLocal;

    @EJB
    private AdminFacadeLocal adminFacadeLocal;

    public String getAuthStr() {
        return authStr;
    }

    public void setAuthStr(String authStr) {
        this.authStr = authStr;
    }
        
    public AdminBean() {
        category = new Category();
        product = new Product();
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

    public List<Product> getProductList() {
        return productFacadeLocal.findAll();
    }
    
    public List<Admin> getAdminList(){
        return adminFacadeLocal.findAll();
    }
    
    @TransactionAttribute
    public void saveCategory() {
        System.out.println("inside saveCategory method");
        System.out.println("category  : " + category.toString());
        //System.out.println("filename :" + category.getImage_file());
        System.out.println("filename :" + category.getImage_file().getFileName() + " file type : " + category.getImage_file().getContentType() + " size : " + category.getImage_file().getSize());
        category.setImage(category.getImage_file().getFileName());
        if (category.getParent_category_id() != null) {
            category.setParentCategory(categoryFacadeLocal.find(category.getParent_category_id()));
        }
        categoryFacadeLocal.create(category);
        Utility.saveImageFile(category);
    }
    
    
    @PostConstruct
    @TransactionAttribute
    public void init() {
        if (categoryFacadeLocal.findAll().isEmpty()) {
            Category cat1 = new Category("This is item1 description", "desktop.jpg", "Desktop");
            Category cat2 = new Category("This is item2 description", "mobile.jpg", "Mobile");
            categoryFacadeLocal.create(cat1);
            categoryFacadeLocal.create(cat2);
        }
      
    }

    public ProductFacadeLocal getProductFacadeLocal() {
        return productFacadeLocal;
    }

    public void setProductFacadeLocal(ProductFacadeLocal productFacadeLocal) {
        this.productFacadeLocal = productFacadeLocal;
    }

    @TransactionAttribute
    public void saveProduct() {
        System.out.println("inside saveProduct");
        productFacadeLocal.create(product);
        product = new Product();
    }

    public String editCategory(Category cat) {
        System.out.println("inside editCategory");
        category = cat;
        return "category";
    }

    @TransactionAttribute
    public void deleteCategory(Category cat) {
        categoryFacadeLocal.remove(cat);
        
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
                Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //return (admin.getPassword()==null);
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