package com.digital.coffeeshop.controller;

import com.digital.coffeeshop.model.BaseResponse;
import com.digital.coffeeshop.model.UserDTO;
import com.digital.coffeeshop.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Shankar Katkade
 * @version 1.0
 * @since 09/03/2023
 *
 * This class handles the request related to users of the coffee shop application
 */

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {


    private UserService userService;

    /**
     * @since 1.0
     * @param userDTO data object with user details parameteres
     * @return User registration response
     */
    @PostMapping(value = "/v1/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> registerUser(@RequestBody @Valid UserDTO userDTO){
        log.info("Inside method: registerUser of class: UserController with request body : {} ", userDTO);
        return userService.registerUser(userDTO);
    }

}
