package dev.lapaix.HospitalApointiment.repository;

import dev.lapaix.HospitalApointiment.model.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability, Long> {
    List<DoctorAvailability> findByDoctorDoctorId(Long doctorId);
}