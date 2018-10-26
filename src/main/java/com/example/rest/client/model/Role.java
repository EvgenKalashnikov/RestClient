package com.example.rest.client.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.List;

public class Role extends Model {

    private static final long serialVersionUID = 7890639962282377869L;
    private String title;
    @JsonBackReference
    private List<User> users = new ArrayList<>();

    public Role() {

    }

    public Role(String title) {
        super();
        this.title = title;
    }

    public Role(int id) {
        super(id);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
