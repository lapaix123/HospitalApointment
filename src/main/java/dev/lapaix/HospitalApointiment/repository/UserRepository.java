package dev.lapaix.HospitalApointiment.repository;

import dev.lapaix.HospitalApointiment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);
}