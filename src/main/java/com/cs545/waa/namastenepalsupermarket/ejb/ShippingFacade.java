/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545.waa.namastenepalsupermarket.ejb;

import com.cs545.waa.namastenepalsupermarket.model.Shipping;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gyanu
 */
@Stateless
public class ShippingFacade extends AbstractFacade<Shipping> implements ShippingFacadeLocal {
    @PersistenceContext(unitName = "com.cs545.waa_NamasteNepalSupermarket_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShippingFacade() {
        super(Shipping.class);
    }
    
}
