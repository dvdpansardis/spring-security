package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import com.example.demo.domain.User;
import com.example.demo.security.CustomSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userName);

        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        CustomSecurityUser customSecurityUser = new CustomSecurityUser(user);

        System.out.println(customSecurityUser.getUsername());
        System.out.println(customSecurityUser.getPassword());

        return customSecurityUser;
    }

}
