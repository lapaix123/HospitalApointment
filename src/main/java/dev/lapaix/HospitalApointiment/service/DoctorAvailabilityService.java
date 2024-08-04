package dev.lapaix.HospitalApointiment.service;

import dev.lapaix.HospitalApointiment.model.DoctorAvailability;

import java.util.List;

public interface DoctorAvailabilityService {
    DoctorAvailability saveAvailability(DoctorAvailability availability);
    List<DoctorAvailability> getAvailabilityByDoctor(Long doctorId);
}
