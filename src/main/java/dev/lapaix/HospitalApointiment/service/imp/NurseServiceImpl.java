package dev.lapaix.HospitalApointiment.service.imp;

import dev.lapaix.HospitalApointiment.model.Nurse;
import dev.lapaix.HospitalApointiment.repository.NurseRepository;
import dev.lapaix.HospitalApointiment.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseServiceImpl implements NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    @Override
    public Nurse saveNurse(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    @Override
    public Nurse getNurseById(Long nurseId) {
        return nurseRepository.findById(nurseId).orElse(null);
    }

    @Override
    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    @Override
    public Nurse updateNurse(Long nurseId, Nurse nurse) {
        if (nurseRepository.existsById(nurseId)) {
            nurse.setNurseId(nurseId);
            return nurseRepository.save(nurse);
        }
        return null;
    }

    @Override
    public boolean deleteNurse(Long nurseId) {

        nurseRepository.deleteById(nurseId);
        return true;
    }
}