package dev.lapaix.HospitalApointiment.repository;

import dev.lapaix.HospitalApointiment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNId(String nId);
    Patient findByPhoneNumber(String phoneNumber);
}