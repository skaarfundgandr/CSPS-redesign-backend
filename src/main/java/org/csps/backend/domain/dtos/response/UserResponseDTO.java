package org.csps.backend.domain.dtos.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    private Long userId;          // from profile
    private String username;      // from account
    private String firstName;     // from profile
    private String lastName;      // from profile
    private String middleName;    // from profile
    private Date birthDate;       // from profile
    private String email;         // from profile
    private String role;          // from account
}
