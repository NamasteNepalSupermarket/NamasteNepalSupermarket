/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545.waa.nns.ejb;

import com.cs545.waa.nns.model.Address;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gyanu
 */
@Stateless
public class AddressFacade extends AbstractFacade<Address> implements AddressFacadeLocal {
    @PersistenceContext(unitName = "com.cs545.waa_NamasteNepalSupermarket_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AddressFacade() {
        super(Address.class);
    }
    
}