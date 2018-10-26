package com.example.rest.client.service;

import com.example.rest.client.model.User;

import java.util.List;

public interface RestClient {
    public List<User> getUsers();
    User getUserByLogin(String login);
    User getUserById(int id);
    void updateUser(User user);
    void deleteUser(int id);
    User saveUser(User user);
}
