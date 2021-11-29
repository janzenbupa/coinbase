package com.api.coinbase;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currency {
    @Id
    private String id;
    private String name;
    private Double min_size;

    public String getId(){
        return this.id;
    }
    public void setId(String _id){
        this.id = _id;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String _name){
        this.name = _name;
    }

    public Double getMin_size(){
        return this.min_size;
    }
    public void setMin_size(Double _min){
        this.min_size = _min;
    }
}
