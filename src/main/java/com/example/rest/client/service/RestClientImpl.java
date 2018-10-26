package com.example.rest.client.service;

import com.example.rest.client.utils.TestErrorHandler;
import com.example.rest.client.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RestClientImpl implements RestClient {

    public List<User> getUsers() {
        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setErrorHandler(new TestErrorHandler());
        final String url = "http://localhost:8080/rest";
        User[] forObject = restTemplate.getForObject(url, User[].class);
        assert forObject != null;
        return Arrays.asList(forObject);
    }

    public User getUserByLogin(String login) {
        final String url = "http://localhost:8080/rest/login/{login}";
        return new RestTemplate().getForObject(url, User.class, login);
    }

    @Override
    public User getUserById(int id) {
        final String url = "http://localhost:8080/rest/{id}";
        return new RestTemplate().getForObject(url, User.class, id);
    }

    @Override
    public void updateUser(User user) {
        final String url = "http://localhost:8080/rest";
        new RestTemplate().put(url,user, User.class);
    }

    @Override
    public void deleteUser(int id) {
        final String url = "http://localhost:8080/rest/{id}";
        new RestTemplate().delete(url, id);
    }

    @Override
    public User saveUser(User user) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new TestErrorHandler());
        final String url = "http://localhost:8080/rest";
        return restTemplate.postForObject(url, user, User.class);
    }

}
