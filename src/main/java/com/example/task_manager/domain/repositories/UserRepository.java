package com.example.task_manager.domain.repositories;

import com.example.task_manager.domain.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Users, Long> {
    UserDetails findByUsername(String username);
}
