package org.csps.backend.domain.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponseDTO {
    private String studentId;
    private Byte yearLevel;
    private UserResponseDTO user;
}
