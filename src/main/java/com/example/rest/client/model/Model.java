package com.example.rest.client.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")

//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "id", scope = Model.class)
public abstract class Model implements Serializable {
    private static final long serialVersionUID = -6359549900797572596L;
    private int id;

    Model() {

    }
    Model(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                '}';
    }
}
