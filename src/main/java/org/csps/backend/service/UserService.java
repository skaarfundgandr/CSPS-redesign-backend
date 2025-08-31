package org.csps.backend.service;

import org.csps.backend.domain.dtos.request.StudentRequestDTO;
import org.csps.backend.domain.dtos.request.UserRequestDTO;
import org.csps.backend.domain.dtos.response.UserResponseDTO;

import java.util.List;

import org.csps.backend.domain.entities.UserAccount;

public interface UserService {
    UserAccount createUser(StudentRequestDTO student, UserRequestDTO userRequestDTO); 
    UserResponseDTO getUserById(Long userId);
    List<UserResponseDTO> getAllUsers();

}
