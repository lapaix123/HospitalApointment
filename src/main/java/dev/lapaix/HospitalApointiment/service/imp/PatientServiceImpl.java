package dev.lapaix.HospitalApointiment.service.imp;

import dev.lapaix.HospitalApointiment.model.Patient;
import dev.lapaix.HospitalApointiment.repository.PatientRepository;
import dev.lapaix.HospitalApointiment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Long patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient updatePatient(Long patientId, Patient patient) {
        if (patientRepository.existsById(patientId)) {
            patient.setPatientId(patientId);
            return patientRepository.save(patient);
        }
        return null;
    }

    @Override
    public void deletePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }
    @Override
    public Patient findByNId(String nId) {
        return patientRepository.findByNId(nId);
    }

    @Override
    public Patient findByPhoneNumber(String phoneNumber) {
        return patientRepository.findByPhoneNumber(phoneNumber);
    }
}