package dev.lapaix.HospitalApointiment.service;

import dev.lapaix.HospitalApointiment.model.Specialization;

import java.util.List;

public interface SpecializationService {
    Specialization saveSpecialization(Specialization specialization);
    Specialization getSpecializationById(Long specializationId);
    List<Specialization> getAllSpecializations();
    Specialization updateSpecialization(Long specializationId, Specialization specialization);
    void deleteSpecialization(Long specializationId);
}
