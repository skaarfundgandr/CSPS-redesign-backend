package org.csps.backend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.csps.backend.domain.dtos.request.StudentRequestDTO;
import org.csps.backend.domain.dtos.response.StudentResponseDTO;
import org.csps.backend.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

   private final StudentService studentService;


   @PostMapping()
   public ResponseEntity<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO studentRequestDTO) {
       StudentResponseDTO createdStudent = studentService.createStudentProfile(studentRequestDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
   }

   @GetMapping()
   public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
       List<StudentResponseDTO> students = studentService.getAllStudents(); // map all Students to StudentResponseDTO
       return ResponseEntity.ok(students);
   }

   @GetMapping("/{studentId}")
   public ResponseEntity<StudentResponseDTO> getStudent(@PathVariable Long studentId) {
       StudentResponseDTO student = studentService.getStudentProfile(studentId); // should be map first to responseDTO
       return ResponseEntity.ok(student);
   }
}
