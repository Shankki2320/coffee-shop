package com.digital.coffeeshop.model;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;

/**
 * @author Shankar Katkade
 * @since 10/03/2023
 * @version 1.0
 *
 * This class contains user request parameters
 */
@Data
public class UserDTO {


    private long id;

    @NotNull(message = "firstName cannot be null")
    private String firstName;

    @NotNull(message = "lastName cannot be null")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String emailId;

    @NotNull(message = "password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8, max = 20, message = "Password should be between 8 and 20 characters")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password should contain at least one letter, one number and be 8-20 characters long")
    private String password;

    @NotNull(message = "roles cannot be null")
    @NotEmpty(message = "roles cannot be empty")
    private List<String> roles;

}
