package com.digital.coffeeshop.repository;

import com.digital.coffeeshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Shankar Katkade
 * @since 09/03/2023
 * @version 1.0
 *
 * This is User repository interface which interacts with the database to persists the data for provided entity
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailId(String emailId);

}
