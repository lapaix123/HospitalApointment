package dev.lapaix.HospitalApointiment.repository;

import dev.lapaix.HospitalApointiment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}