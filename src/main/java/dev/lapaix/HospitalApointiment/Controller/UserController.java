package dev.lapaix.HospitalApointiment.Controller;

import dev.lapaix.HospitalApointiment.model.User;
import dev.lapaix.HospitalApointiment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/total")
    public long getTotalUsers() {
        return userService.getTotalUsers();
    }
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        User authenticatedUser = userService.login(user.getEmail(), user.getPassword());
        if (authenticatedUser != null) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/current")
    public ResponseEntity<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.getUserByEmail(userDetails.getUsername());
        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
        User updatedUser = userService.updateUser(userId, user);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser() {
        // Placeholder for any logout logic or cleanup
        return new ResponseEntity<>("Logout successful", HttpStatus.OK);
    }

}
