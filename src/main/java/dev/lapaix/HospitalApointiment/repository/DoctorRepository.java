package dev.lapaix.HospitalApointiment.repository;

import dev.lapaix.HospitalApointiment.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}