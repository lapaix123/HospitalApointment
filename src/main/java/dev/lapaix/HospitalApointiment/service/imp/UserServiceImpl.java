package dev.lapaix.HospitalApointiment.service.imp;

import dev.lapaix.HospitalApointiment.model.User;
import dev.lapaix.HospitalApointiment.repository.UserRepository;
import dev.lapaix.HospitalApointiment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long userId, User user) {
        if (userRepository.existsById(userId)) {
            user.setUserId(userId);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    @Override
    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}