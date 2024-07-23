package dev.lapaix.HospitalApointiment.service;

import dev.lapaix.HospitalApointiment.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);
    User login(String email, String password);
}
