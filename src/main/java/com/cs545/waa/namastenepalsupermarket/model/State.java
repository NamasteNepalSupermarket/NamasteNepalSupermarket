/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs545.waa.namastenepalsupermarket.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Bishal Timilsina
 */
@Entity
class State implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String correspondingCountry;    
    private Integer zipcodeStart;

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
    public Integer getZipcodeStart() {
        return zipcodeStart;
    }
    public void setZipcodeStart(Integer zipcodeStart) {
        this.zipcodeStart = zipcodeStart;
    }                
}