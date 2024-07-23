package dev.lapaix.HospitalApointiment.service;

import dev.lapaix.HospitalApointiment.model.Patient;

import java.util.List;

public interface PatientService {
    Patient savePatient(Patient patient);
    Patient getPatientById(Long patientId);
    List<Patient> getAllPatients();
    Patient updatePatient(Long patientId, Patient patient);
    void deletePatient(Long patientId);
    Patient findByNId(String nId);
    Patient findByPhoneNumber(String phoneNumber);
}