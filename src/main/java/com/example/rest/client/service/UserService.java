package com.example.rest.client.service;


import com.example.rest.client.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User getUserByLogin(String login);
    List<User> loadAllUsers();
    void deleteUser(User user);
    void updateUser(User user);
    User finUserById(int id);

}
