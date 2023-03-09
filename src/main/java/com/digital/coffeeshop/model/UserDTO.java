package com.digital.coffeeshop.model;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private List<String> roles;



}
