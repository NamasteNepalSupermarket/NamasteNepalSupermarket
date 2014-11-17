/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545.waa.namastenepalsupermarket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Bishal Timilsina
 */
@Entity
public class State {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String correspondingCountry;
        //private List<Integer> zipcodeStarts;

    public State() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCorrespondingCountry() {
        return correspondingCountry;
    }

    public void setCorrespondingCountry(String correspondingCountry) {
        this.correspondingCountry = correspondingCountry;
    }
//        public List<Integer> getZipcodeStarts() {
//            return zipcodeStarts;
//        }
//        public void setZipcodeStarts(List<Integer> zipcodeStarts) {
//            this.zipcodeStarts = zipcodeStarts;
//        }                
}
