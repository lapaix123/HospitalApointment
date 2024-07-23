package dev.lapaix.HospitalApointiment.repository;

import dev.lapaix.HospitalApointiment.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Nurse, Long> {
}