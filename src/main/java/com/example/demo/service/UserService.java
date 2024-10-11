package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.exception.AppException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired 
    private PasswordEncoder passwordEncoder; 
    public boolean  authenticate(String username, String rawPassword){
        User user = userRepository.findByUsername(username).orElseThrow(()-> new RuntimeException("User not found"));
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }
    public User createUser(UserCreationRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        if (userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED); 
        }
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstname(request.getFirsname());
        user.setLastname(request.getLastname());

        return userRepository.save(user);
    }
    public List<User> getUsers(){
        return userRepository.findAll(); 
    }
    public User getUser(String id){
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("user not found")); 
    }
    public User updatUser(String userId, UserUpdateRequest request){
        User user = getUser(userId);
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirsname());
        user.setLastname(request.getLastname());
        return userRepository.save(user);
    }
    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }
}
