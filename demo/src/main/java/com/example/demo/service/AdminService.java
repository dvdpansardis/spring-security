package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Secured({"ROLE_ADMIN", "ROLE_SUPERUSER"})
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
