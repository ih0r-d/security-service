package io.codepyxis.service;

import io.codepyxis.domain.model.User;
import io.codepyxis.domain.repository.UserRepository;
import io.codepyxis.exception.CustomException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthSecurity {

    private final UserRepository userRepository;

    public void signup(User user){
        if (!userRepository.existsByUsername(user.getUsername())) {
            userRepository.save(user);
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);

        }
    }

    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }

    public User search(String username) {
        return userRepository.findByUsername(username).orElseThrow(()->new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND));
    }


}
