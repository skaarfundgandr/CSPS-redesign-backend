package org.csps.backend.domain.dtos.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.csps.backend.domain.enums.UserRole;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPatchDTO {

    @Size(max = 50, message = "First name must not exceed 50 characters")
    private String firstName;

    @Size(max = 50, message = "Last name must not exceed 50 characters")
    private String lastName;

    @Size(max = 50, message = "Middle name must not exceed 50 characters")
    private String middleName;

    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @Email(message = "Invalid email format")
    private String email;
}
