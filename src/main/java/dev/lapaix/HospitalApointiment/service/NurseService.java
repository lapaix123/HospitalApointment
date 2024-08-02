package dev.lapaix.HospitalApointiment.service;

import dev.lapaix.HospitalApointiment.model.Nurse;

import java.util.List;

public interface NurseService {
    Nurse saveNurse(Nurse nurse);
    Nurse getNurseById(Long nurseId);
    List<Nurse> getAllNurses();
    Nurse updateNurse(Long nurseId, Nurse nurse);
    boolean deleteNurse(Long nurseId);
    long getTotalNurses();

}
