package com.example.task_manager.services.impl;

import com.example.task_manager.domain.models.Users;
import com.example.task_manager.domain.repositories.UserRepository;
import com.example.task_manager.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails findByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    @Override
    public Users create(Users users) {
        return null;
    }
}
