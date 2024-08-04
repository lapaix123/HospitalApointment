package dev.lapaix.HospitalApointiment.service.imp;

import dev.lapaix.HospitalApointiment.model.DoctorAvailability;
import dev.lapaix.HospitalApointiment.repository.DoctorAvailabilityRepository;
import dev.lapaix.HospitalApointiment.service.DoctorAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorAvailabilityImpl implements DoctorAvailabilityService {
    @Autowired
    private DoctorAvailabilityRepository doctorAvailabilityRepository;

    @Override
    public DoctorAvailability saveAvailability(DoctorAvailability availability) {
        return doctorAvailabilityRepository.save(availability);
    }

    @Override
    public List<DoctorAvailability> getAvailabilityByDoctor(Long doctorId) {
        return doctorAvailabilityRepository.findByDoctorDoctorId(doctorId);
    }
}
