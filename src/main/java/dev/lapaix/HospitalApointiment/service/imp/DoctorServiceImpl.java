package dev.lapaix.HospitalApointiment.service.imp;

import dev.lapaix.HospitalApointiment.model.Doctor;
import dev.lapaix.HospitalApointiment.repository.DoctorRepository;
import dev.lapaix.HospitalApointiment.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId).orElse(null);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor updateDoctor(Long doctorId, Doctor doctor) {
        if (doctorRepository.existsById(doctorId)) {
            doctor.setDoctorId(doctorId);
            return doctorRepository.save(doctor);
        }
        return null;
    }

    @Override
    public void deleteDoctor(Long doctorId) {
        doctorRepository.deleteById(doctorId);
    }
}