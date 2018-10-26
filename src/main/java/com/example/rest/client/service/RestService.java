package com.example.rest.client.service;

import com.example.rest.client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestService implements UserService {
    private final
    RestClient client;

    @Autowired
    public RestService(RestClient client) {
        this.client = client;
    }


    @Override
    public User save(User user) {
        return client.saveUser(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return client.getUserByLogin(login);
    }

    @Override
    public List<User> loadAllUsers() {
        return client.getUsers();
    }

    @Override
    public void deleteUser(User user) {
        client.deleteUser(user.getId());
    }

    @Override
    public void updateUser(User user) {
        client.updateUser(user);
    }

    @Override
    public User finUserById(int id) {
       return client.getUserById(id);
    }
}
