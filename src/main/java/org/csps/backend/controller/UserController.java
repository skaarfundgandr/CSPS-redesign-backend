package org.csps.backend.controller;

import java.util.List;

import org.csps.backend.domain.dtos.response.UserResponseDTO;
import org.csps.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/get")
    public ResponseEntity<?> getAllUser() {
        List<UserResponseDTO> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    
}
