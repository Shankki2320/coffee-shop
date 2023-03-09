package com.digital.coffeeshop.service;

import com.digital.coffeeshop.model.BaseResponse;
import com.digital.coffeeshop.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author Shankar Katkade
 * @version 1.0
 * @since 09/03/2023
 *
 * This is a User service interface which holds the abstract methods for User related functionalities
 */
@Component
public interface UserService {

    /**
     * @param userDTO user request parameters
     * @return User registration response
     */
    ResponseEntity<BaseResponse> registerUser(UserDTO userDTO);

}
