package dev.lapaix.HospitalApointiment.service;

import dev.lapaix.HospitalApointiment.model.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);
    Doctor getDoctorById(Long doctorId);
    List<Doctor> getAllDoctors();
    Doctor updateDoctor(Long doctorId, Doctor doctor);
    void deleteDoctor(Long doctorId);
    long getTotalDoctors();
}
