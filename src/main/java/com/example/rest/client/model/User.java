package com.example.rest.client.model;

import java.util.ArrayList;
import java.util.List;


public class User extends Model {
    private String login;

    private String password;
    private String email;

    private List<Role> roles = new ArrayList<>();
    public User() {

    }

    public User(int id, String login, String password, String email) {
        super(id);
        this.login = login;
        this.password = password;
        this.email = email;

    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(String login, String password, List<Role> roles, String email) {
        this.login = login;
        this.password = password;
        this.roles = roles;
        this.email = email;
    }

    public User(int id, String login, String password, String email, List<Role> roles) {
        super(id);
        this.login = login;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }



    public User(String login, String password, String email, List<Role> roles) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}