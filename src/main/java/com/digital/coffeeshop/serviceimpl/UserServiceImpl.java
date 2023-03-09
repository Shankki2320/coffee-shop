package com.digital.coffeeshop.serviceimpl;

import com.digital.coffeeshop.entity.Role;
import com.digital.coffeeshop.entity.User;
import com.digital.coffeeshop.exceptions.ResourceAlreadyExistException;
import com.digital.coffeeshop.model.BaseResponse;
import com.digital.coffeeshop.model.UserDTO;
import com.digital.coffeeshop.repository.UserRepository;
import com.digital.coffeeshop.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author Shankar Katkade
 * @version 1.0
 * @since 09/03/2023
 * This class contains the implementation of the abstract methods of UserService
 */

@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    /**
     * @param userDTO user request parameters
     * @return User registration exception
     * @throws ResourceAlreadyExistException if an already registered user is trying to create an account
     * @since 1.0
     */
    @Override
    public ResponseEntity<BaseResponse> registerUser(UserDTO userDTO) {
        log.info("inside method: registerUser of class: UserServiceImpl with request : {} ", userDTO);
        BaseResponse baseResponse = new BaseResponse();
        //check for existing user
        Optional<User> user = userRepository.findByEmailId(userDTO.getEmailId());
        if (user.isPresent()) {
            log.error("User with given mail id already exist.");
            throw new ResourceAlreadyExistException("User with email already exists, please login to proceed further");
        }
        User userDetails = new User();
        BeanUtils.copyProperties(userDTO, userDetails);
        userDetails.setRoles(setUserRoles(userDTO.getRoles()));
        User userId = userRepository.save(userDetails);
        baseResponse.setData("UserId : " + userId.getId());
        baseResponse.setMessage("User registered successfully");
        log.info("User registered successfully with ID : {}", userId.getId());
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }

    private Set<Role> setUserRoles(List<String> requestRoles) {
        Set<Role> roles = new HashSet<>();
        for (String role : requestRoles) {
            Role userRole = new Role();
            userRole.setRole(role);
            roles.add(userRole);
        }
        return roles;
    }
}
