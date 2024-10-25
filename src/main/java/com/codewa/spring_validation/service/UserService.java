package com.codewa.spring_validation.service;

import com.codewa.spring_validation.dto.UserRequest;
import com.codewa.spring_validation.entity.User;
import com.codewa.spring_validation.haldler.UserNotFoundException;
import com.codewa.spring_validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) throws UserNotFoundException {
        User user = userRepository.findByUserId(id);
        if (user != null) {
            return user;
        }
        throw new UserNotFoundException("user not found");
    }
}
