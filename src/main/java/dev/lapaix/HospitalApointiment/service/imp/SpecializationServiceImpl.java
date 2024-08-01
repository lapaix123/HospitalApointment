package dev.lapaix.HospitalApointiment.service.imp;

import dev.lapaix.HospitalApointiment.model.Specialization;
import dev.lapaix.HospitalApointiment.repository.SpecializationRepository;
import dev.lapaix.HospitalApointiment.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpecializationServiceImpl implements SpecializationService {
    @Autowired
    private SpecializationRepository specializationRepository;

    @Override
    public Specialization saveSpecialization(Specialization specialization) {
        return specializationRepository.save(specialization);
    }

    @Override
    public Specialization getSpecializationById(Long specializationId) {
        return specializationRepository.findById(specializationId).orElse(null);
    }

    @Override
    public List<Specialization> getAllSpecializations() {
        return specializationRepository.findAll();
    }

    @Override
    public Specialization updateSpecialization(Long specializationId, Specialization specialization) {
        Specialization existingSpecialization = getSpecializationById(specializationId);
        if (existingSpecialization != null) {
            existingSpecialization.setName(specialization.getName());
            return specializationRepository.save(existingSpecialization);
        }
        return null;
    }

    @Override
    public void deleteSpecialization(Long specializationId) {
        specializationRepository.deleteById(specializationId);
    }
}
