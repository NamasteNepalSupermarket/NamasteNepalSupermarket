/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545.waa.nns.controller;

import com.cs545.waa.nns.ejb.CategoryFacadeLocal;
import com.cs545.waa.nns.model.Category;
import java.io.Serializable;
import java.util.List;
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
public class UserBean implements Serializable {

    @EJB
    private CategoryFacadeLocal categoryFacade;
    private Category category;

    public UserBean() {
        category = new Category();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @TransactionAttribute
    public void create() {
        System.out.println("inside create");
        Category cat = new Category();
        cat.setName(category.getName());
        cat.setDescription(category.getDescription());
        categoryFacade.create(cat);
        //  categoryFacade.findAll();
        // List<Category> catList= categoryFacadeLocal.findAll();
        // System.out.println("cat list size : "+catList.size());
    }

    public List<Category> categoryList() {
        return categoryFacade.findAll();
    }

    public CategoryFacadeLocal getCategoryFacade() {
        return categoryFacade;
    }

    public void setCategoryFacade(CategoryFacadeLocal categoryFacade) {
        this.categoryFacade = categoryFacade;
    }
}
