package com.dreamsw.security.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Daniel
 * @Date 08/04/2023
 */

public interface UserRepository extends JpaRepository<User, Integer> {

    // In JpaRepository if we want to make a specific query like "find by field" we only need to name the method
    // findBy + class attribute. In this case email using camelcase , ps Java is great! <3
    Optional<User> findByEmail(String email);

}
