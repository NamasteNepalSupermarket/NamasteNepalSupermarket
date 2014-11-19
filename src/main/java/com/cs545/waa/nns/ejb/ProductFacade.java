/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545.waa.nns.ejb;

import com.cs545.waa.nns.model.Category;
import com.cs545.waa.nns.model.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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

   /* @Override
    public List<Product> getProductByCategory(Long catId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        List<Product> products = (List<Product>) cb.createQuery(Product.class);
        Root<Product> prod = cb.from(Product.class);
        Root<Category> cat = cb.from(Category.class);
//        cb.select(dept)
//                .distinct(true)
//                .where(cb.equal(dept, emp.get("department")));

        return null;

    }*/

}
