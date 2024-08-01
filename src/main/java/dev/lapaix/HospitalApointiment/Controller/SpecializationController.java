package dev.lapaix.HospitalApointiment.Controller;

import dev.lapaix.HospitalApointiment.model.Specialization;
import dev.lapaix.HospitalApointiment.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specializations")
public class SpecializationController {

    @Autowired
    private SpecializationService specializationService;

    @PostMapping("/create")
    public ResponseEntity<Specialization> createSpecialization(@RequestBody Specialization specialization) {
        Specialization newSpecialization = specializationService.saveSpecialization(specialization);
        return new ResponseEntity<>(newSpecialization, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialization> getSpecializationById(@PathVariable Long id) {
        Specialization specialization = specializationService.getSpecializationById(id);
        if (specialization != null) {
            return new ResponseEntity<>(specialization, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Specialization>> getAllSpecializations() {
        List<Specialization> specializations = specializationService.getAllSpecializations();
        return new ResponseEntity<>(specializations, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Specialization> updateSpecialization(@PathVariable Long id, @RequestBody Specialization specializationDetails) {
        Specialization updatedSpecialization = specializationService.updateSpecialization(id, specializationDetails);
        if (updatedSpecialization != null) {
            return new ResponseEntity<>(updatedSpecialization, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSpecialization(@PathVariable Long id) {
        specializationService.deleteSpecialization(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
