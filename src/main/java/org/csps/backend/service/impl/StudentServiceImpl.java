package org.csps.backend.service.impl;

import org.csps.backend.domain.dtos.request.StudentRequestDTO;
import org.csps.backend.domain.dtos.response.StudentResponseDTO;
import org.csps.backend.domain.entities.Student;
import org.csps.backend.exception.StudentNotFoundException;
import org.csps.backend.mapper.StudentMapper;
import org.csps.backend.repository.StudentRepository;
import org.csps.backend.service.StudentService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.csps.backend.domain.entities.UserAccount;
import org.csps.backend.service.UserService;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

   private final StudentMapper studentMapper;
   private final StudentRepository studentRepository;

   private final UserService userService;
    
    @Override
    public StudentResponseDTO createStudentProfile(StudentRequestDTO studentRequestDTO) {

        // Create UserAccount from nested UserRequestDTO
        UserAccount savedUserAccount = userService.createUser(studentRequestDTO, studentRequestDTO.getUserRequestDTO());

        // Map Student entity
        Student student = studentMapper.toEntity(studentRequestDTO);
        student.setUserAccount(savedUserAccount);

        // Persist Student
        student = studentRepository.save(student);

        // Map to DTO
        return studentMapper.toResponseDTO(student);
    }


    // Get all Students
   @Override
   public List<StudentResponseDTO> getAllStudents() {
       return studentRepository.findAll().stream()
               .map(studentMapper::toResponseDTO)
               .toList();
   }


   // Get Student By Id
   @Override
   public StudentResponseDTO getStudentProfile(Long studentId) {
       Student existingStudent = studentRepository.findById(studentId)
               .orElseThrow(() -> new StudentNotFoundException(studentId));
       return studentMapper.toResponseDTO(existingStudent);
   }

}
