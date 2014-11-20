/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545.waa.nns.controller;

import com.cs544.waa.nns.util.Utility;
import com.cs545.waa.nns.ejb.CategoryFacadeLocal;
import com.cs545.waa.nns.ejb.ProductFacadeLocal;
import com.cs545.waa.nns.model.Category;
import com.cs545.waa.nns.model.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author gyanu
 */
@Named
@RequestScoped
public class AdminBean implements Serializable {

    private Category category;
    private Product product;
    private int activeCatId;
    private int activeProductId;

   

    @EJB
    private CategoryFacadeLocal categoryFacadeLocal;

    @EJB
    private ProductFacadeLocal productFacadeLocal;

    public AdminBean() {
        category = new Category();
        product = new Product();
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

    public ProductFacadeLocal getProductFacadeLocal() {
        return productFacadeLocal;
    }

    public void setProductFacadeLocal(ProductFacadeLocal productFacadeLocal) {
        this.productFacadeLocal = productFacadeLocal;
    }

    //TODO : parent category filtering
    public List<Category> getCategoryList() {
        return categoryFacadeLocal.findAll();
    }

    public List<Product> getProductList() {
        return productFacadeLocal.findAll();
    }

    public List<Product> getOnlyFourProductList() {
        int[] range = new int[]{0, 4};
        return productFacadeLocal.findRange(range);
    }

    public List<Category> getOnlyFourCategoryList() {
        int[] range = new int[]{0, 7};
        return categoryFacadeLocal.findRange(range);
    }

    @TransactionAttribute
    public String saveCategory() {
        System.out.println("inside saveCategory method");
        System.out.println("category  : " + category.toString());
        //System.out.println("filename :" + category.getImage_file());
        System.out.println("filename :" + category.getImage_file().getFileName() + " file type : " + category.getImage_file().getContentType() + " size : " + category.getImage_file().getSize());
        if (category.getId() == null) {
            //save operation
            category.setImage(category.getImage_file().getFileName());
            if (category.getParent_category_id() != null) {
                category.setParentCategory(categoryFacadeLocal.find(category.getParent_category_id()));
            }
            categoryFacadeLocal.create(category);
            Utility.saveImageFile(category);

        } else {
            //edit operation
        }
        return "category";
    }

    @TransactionAttribute
    public void saveProduct() {
        /*
         product.setImage(product.getImage_file().getFileName());
         if (category.getParent_category_id() != null) {
         category.setParentCategory(categoryFacadeLocal.find(category.getParent_category_id()));
         }
         */
        productFacadeLocal.create(product);
        //Utility.saveImageFile(category);
    }

    @PostConstruct
    @TransactionAttribute
    public void init() {
        if (categoryFacadeLocal.findAll().isEmpty()) {
            Category cat1 = new Category("This is item1 description", "desktop.jpg", "Desktop");
            Category cat2 = new Category("This is item2 description", "mobile.jpg", "Mobile");
            Category cat3 = new Category("This is item2 description", "laptops.jpg", "Laptops");
            Category cat4 = new Category("This is item2 description", "pc.jpg", "PC");
            Category cat5 = new Category("This is item2 description", "macs.jpg", "Macs");
            Category cat6 = new Category("This is item2 description", "windows.jpg", "Windows");
            Category cat7 = new Category("This is item2 description", "tablets.jpg", "Tablets");
            categoryFacadeLocal.create(cat1);
            categoryFacadeLocal.create(cat2);
            categoryFacadeLocal.create(cat3);
            categoryFacadeLocal.create(cat4);
            categoryFacadeLocal.create(cat5);
            categoryFacadeLocal.create(cat6);
            categoryFacadeLocal.create(cat7);

            List<Category> catlist1 = new ArrayList<>();
            catlist1.add(cat1);
            catlist1.add(cat2);
            List<Category> catlist2 = new ArrayList<>();
            catlist2.add(cat3);
            catlist2.add(cat2);
            List<Category> catlist3 = new ArrayList<>();
            catlist3.add(cat4);
            catlist3.add(cat1);
            List<Category> catlist4 = new ArrayList<>();
            catlist4.add(cat5);
            catlist4.add(cat4);
            List<Category> catlist5 = new ArrayList<>();
            catlist5.add(cat6);
            catlist5.add(cat7);
            List<Category> catlist6 = new ArrayList<>();
            catlist6.add(cat7);
            catlist6.add(cat2);
            List<Category> catlist7 = new ArrayList<>();
            catlist7.add(cat1);
            catlist7.add(cat2);
            Product product1 = new Product("Apple", "This is Apple description", "apple_logo.jpg", 100, "s5", 20, true, catlist1);
            Product product2 = new Product("Canon EOS", "This is Canon EOS", "canon_eos_5d_1.jpg", 100, "s5", 20, true, catlist2);
            Product product3 = new Product("HTC Touch HD", "This is samsung galaxy s", "htc_touch_hd_1.jpg", 100, "s5", 20, true, catlist3);
            Product product4 = new Product("Iphone 6", "This is samsung galaxy s", "iphone_6.jpg", 100, "s5", 20, true, catlist4);
            Product product5 = new Product("Ipod Classic", "This is samsung galaxy s", "ipod_classic_2.jpg", 100, "s5", 20, true, catlist5);
            Product product6 = new Product("Mac Book", "This is samsung galaxy s", "macbook_2.jpg", 100, "s5", 20, true, catlist6);
            Product product7 = new Product("Mac Book Pro", "This is samsung galaxy s", "macbook_pro_4.jpg", 100, "s5", 20, true, catlist7);
            productFacadeLocal.create(product1);
            productFacadeLocal.create(product2);
            productFacadeLocal.create(product3);
            productFacadeLocal.create(product4);
            productFacadeLocal.create(product5);
            productFacadeLocal.create(product6);
            productFacadeLocal.create(product7);
        }

    }

    @TransactionAttribute
    public void deleteCategory(long catId) {
        System.out.println("inside delete Category : " + catId);
        categoryFacadeLocal.remove(categoryFacadeLocal.find(catId));
    }

    @TransactionAttribute
    public void editCategory(long catId) {
        System.out.println("inside delete Category : " + catId);
        category = categoryFacadeLocal.find(catId);
    }

    
    
    @TransactionAttribute
    public List<Product> getProductsByCategory(int catId) {
        System.out.println("inside get product list for category : " + catId);
        return productFacadeLocal.findProductsByCategory(catId);
    }

    public String gotoCategoryPage(int catId) {
        //getProductsByCategory(catId);
       //getCategoryDetails(catId);
        setActiveCatId(catId);
        return "category";
    }
    @TransactionAttribute
    public Product productDetails(long productId) {
        return productFacadeLocal.find(productId);
    }
    public String gotoProductPage(int productId){
        System.out.println(productId+"in go to product page");
        setActiveProductId(productId);
        return "product";
    }
    
    public Category getCategoryDetails(int catId){
        return categoryFacadeLocal.find(catId);
    }

    public int getActiveCatId() {
        return activeCatId;
    }
    public int getActiveProductId() {
        return activeProductId;
    }

    public void setActiveProductId(int activeProductId) {
        this.activeProductId = activeProductId;
    }
    public void setActiveCatId(int activeCatId) {
        this.activeCatId = activeCatId;
    }

}
