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
import javax.persistence.Transient;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Bishal Timilsina
 */
@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private String image;
    private String name;
    @Transient
    private UploadedFile image_file;
    @Transient
    private Long parent_category_id;
    @ManyToOne
    private Category parentCategory;
    @ManyToMany(mappedBy = "categories", cascade = CascadeType.REMOVE)
    private List<Product> products;

    public Category() {
        products = new ArrayList<>();
    }

    public Category(String description, String image, String name) {
        this.description = description;
        this.image = image;
        this.name = name;
        products = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParent_category_id() {
        return parent_category_id;
    }

    public void setParent_category_id(Long parent_category_id) {
        this.parent_category_id = parent_category_id;
    }

    public UploadedFile getImage_file() {
        return image_file;
    }

    public void setImage_file(UploadedFile image_file) {
        this.image_file = image_file;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs545.waa.namastenepalsupermarket.model.Categor[ id=" + id + ", name=" + name + ",description=" + description + ",parent_cat=" + parent_category_id + " ]";
    }
}
