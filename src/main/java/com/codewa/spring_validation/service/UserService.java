package com.codewa.spring_validation.service;

import com.codewa.spring_validation.dto.UserRequest;
import com.codewa.spring_validation.entity.User;
import com.codewa.spring_validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserRequest userRequest) {
        User user = User.build(0, userRequest.getName(),
                userRequest.getEmail(), userRequest.getPhone(),
                userRequest.getGender(), userRequest.getAge(),
                userRequest.getNationality());
        return userRepository.save(user);
    }
}
