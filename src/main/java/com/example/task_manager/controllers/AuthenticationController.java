package com.example.task_manager.controllers;

import com.example.task_manager.DTO.RegisterRequestDTO;
import com.example.task_manager.domain.models.Users;
import com.example.task_manager.services.UserService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<UserDetails> register(@RequestBody @Valid RegisterRequestDTO data){
        if(userService.findByUsername(data.username()) != null) return ResponseEntity.badRequest().build();

        String encryptedPass = new BCryptPasswordEncoder().encode(data.password());
        Users newUser = new Users(data.username(), encryptedPass);

        Users created = userService.create(newUser);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.ok().build();
    }
}
