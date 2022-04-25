package com.smart.house.security.jwtConfig.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.smart.house.security.jwtConfig.SecurityUtils;
import com.smart.house.security.jwtConfig.model.User;
import com.smart.house.security.jwtConfig.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities() {
        return SecurityUtils.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
    }

}