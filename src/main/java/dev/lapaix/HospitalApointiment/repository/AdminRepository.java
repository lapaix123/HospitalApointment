package dev.lapaix.HospitalApointiment.repository;

import dev.lapaix.HospitalApointiment.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}