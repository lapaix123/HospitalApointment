package dev.lapaix.HospitalApointiment.repository;

import dev.lapaix.HospitalApointiment.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
}