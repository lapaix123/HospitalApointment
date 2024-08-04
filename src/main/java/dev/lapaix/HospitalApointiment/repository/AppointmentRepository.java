package dev.lapaix.HospitalApointiment.repository;

import dev.lapaix.HospitalApointiment.model.Appointment;
import dev.lapaix.HospitalApointiment.model.enumeration.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
//    List<Appointment> findByDoctorIdAndStatus(Long doctorId, AppointmentStatus status);

}