package com.example.rest.client.service;


import com.example.rest.client.model.Role;
import com.example.rest.client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UserDetaisServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public UserDetaisServiceImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.getUserByLogin(userName);
        if (user != null) {
            String[] roles = user.getRoles().stream().map(Role::getTitle).toArray(String[]::new);
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (String s : roles) {
                authorities.add(new SimpleGrantedAuthority(s));
            }
            return new org.springframework.security.core.userdetails.User(
                    user.getLogin(), user.getPassword(), authorities);
        }
        throw new UsernameNotFoundException(
                "User :" + userName + "not found"
        );
    }
}
