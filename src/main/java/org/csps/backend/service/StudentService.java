package org.csps.backend.service;

import org.csps.backend.domain.dtos.request.StudentRequestDTO;
import org.csps.backend.domain.dtos.response.StudentResponseDTO;

import java.util.List;


public interface StudentService {
   StudentResponseDTO createStudentProfile(StudentRequestDTO studentRequestDTO);
   public List<StudentResponseDTO> getAllStudents();
   StudentResponseDTO getStudentProfile(Long studentId);
}
