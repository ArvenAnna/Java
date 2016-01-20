/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anna.prefixmatches;

import java.util.Objects;

/**
 * Class represents tuple of term and its weigh as its length
 * @author Hanna_Sira
 */
public class Tuple {
  
    private final String term;
    private final Integer weigh;
    
    public Tuple(String term){
        this.term = term;
        this.weigh = term.length();
    }
    
    public String getTerm(){
        return term;
    }
    
    public Integer getWeigh(){
        return weigh;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.term);
        hash = 53 * hash + Objects.hashCode(this.weigh);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tuple other = (Tuple) obj;
        if (!Objects.equals(this.term, other.term)) {
            return false;
        }
        if (!Objects.equals(this.weigh, other.weigh)) {
            return false;
        }
        return true;
    }
}
