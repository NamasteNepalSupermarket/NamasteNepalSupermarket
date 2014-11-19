/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545.waa.nns.ejb;

import com.cs545.waa.nns.model.Product;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author gyanu
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeLocal {
    @PersistenceContext(unitName = "com.cs545.waa_NamasteNepalSupermarket_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }

    @Override
    public List<Product> findProductsByCategory(int id) {
        System.out.println("inside findProductsByCategory ");
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> productRoot = criteriaQuery.from(Product.class);
        Expression<Collection<String>> categoryIds = productRoot.get("categories");
        Predicate containsFavoritedProduct = criteriaBuilder.isMember(String.valueOf(id), categoryIds);
        criteriaQuery.where(containsFavoritedProduct);

        //Root<Category> categoryRoot = criteriaQuery.from(Category.class);
        
        // criteriaQuery.select(productRoot).distinct(true).where(criteriaBuilder.equal(categoryRoot, productRoot.get("categories")));
        TypedQuery<Product> q = em.createQuery(criteriaQuery);
        System.out.println("query : " + criteriaQuery.toString() + ">>>" + q.toString());
        List<Product> productList = q.getResultList();
        System.out.println("productlist : " + productList.size()
        );
        return productList;
    }

}
