package com.smart.house.service;

import com.smart.house.entity.User;
import com.smart.house.enums.ERole;
import com.smart.house.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {


    private static final String REGISTRATION_SUCCESSFUL = "registration_successful";

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;





    public List<User> getAll() {

        return userRepository.findAll();
    }


    public Optional<User> findByUsername(String username) {

        return userRepository.findByUsername(username);

    }


    public void registration() {

        final User user = new User();


        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(ERole.ROLE_USER));

        userRepository.save(user);

        final String username = user.getUsername();

        log.info("{} registered successfully!", username);

    }


    public Optional<User> findAuthenticatedUserByUsername(String username) {

        return findByUsername(username);

    }
}
