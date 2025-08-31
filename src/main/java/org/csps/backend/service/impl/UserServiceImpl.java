package org.csps.backend.service.impl;

import java.util.List;

import org.csps.backend.domain.dtos.request.StudentRequestDTO;
import org.csps.backend.domain.dtos.request.UserRequestDTO;
import org.csps.backend.domain.dtos.response.UserResponseDTO;
import org.csps.backend.domain.entities.UserAccount;
import org.csps.backend.domain.entities.UserProfile;
import org.csps.backend.domain.enums.UserRole;
import org.csps.backend.exception.EmailAlreadyExistsException;
import org.csps.backend.exception.UserAlreadyExistsException;
import org.csps.backend.exception.UserNotFoundException;
import org.csps.backend.mapper.UserMapper;
import org.csps.backend.repository.UserAccountRespository;
import org.csps.backend.repository.UserProfileRepository;
import org.csps.backend.service.UserService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserAccountRespository userAccountRespository;
    private final UserProfileRepository userProfileRepository;
    
    @Value("${csps.userNameformat}")
    private String userNameFormat;
    @Value("${csps.passwordformat}")
    private String passwordFormat;

    
    // Create User (for students atm, will do for Admin soon)
    @Override
    public UserAccount createUser(StudentRequestDTO student, UserRequestDTO userRequestDTO) {
        // check if username already exists
        String generatedUsername = userNameFormat + userRequestDTO.getFirstName();

        if (userAccountRespository.existsByUsername(generatedUsername)) {
            throw new UserAlreadyExistsException("Username already exists: " + generatedUsername);
        }
        if (userProfileRepository.existsByEmail(userRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException(userRequestDTO.getEmail());
        }

        // Create and save UserProfile
        UserProfile userProfile = userMapper.toUserProfile(userRequestDTO);
        UserProfile savedProfile = userProfileRepository.save(userProfile);

        // Create UserAccount and link it to the saved profile
        UserAccount userAccount = userMapper.toUserAccount(userRequestDTO);
        userAccount.setUserProfile(savedProfile);
        userAccount.setPassword(String.format("%s-%s", passwordFormat, userRequestDTO.getFirstName())); // you’ll later hash this
        userAccount.setUsername(String.format("%s-%s", userNameFormat, student.getStudentId()));
        userAccount.setRole(UserRole.STUDENT);

        return userAccountRespository.save(userAccount);
    }


    // Get User By Id 
    @Override
    public UserResponseDTO getUserById(Long userId) {
        UserAccount existingUser = userAccountRespository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        return userMapper.toResponseDTO(existingUser);
    }

    // Get All Users
    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userAccountRespository.findAll().stream()
                .map(userMapper::toResponseDTO)
                .toList();
    }

}
