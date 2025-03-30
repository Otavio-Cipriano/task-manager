package com.example.task_manager.services;

import com.example.task_manager.domain.models.Users;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserDetails findByUsername(String username);

    Users create(Users users);
}
