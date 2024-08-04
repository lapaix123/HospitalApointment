package dev.lapaix.HospitalApointiment.Controller;

import dev.lapaix.HospitalApointiment.model.DoctorAvailability;
import dev.lapaix.HospitalApointiment.service.DoctorAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor-availability")
public class DoctorAvailabilityController {

    @Autowired
    private DoctorAvailabilityService doctorAvailabilityService;

    @PostMapping("/set")
    public ResponseEntity<DoctorAvailability> setAvailability(@RequestBody DoctorAvailability availability) {
        return ResponseEntity.ok(doctorAvailabilityService.saveAvailability(availability));
    }

    @GetMapping("/get/{doctorId}")
    public ResponseEntity<List<DoctorAvailability>> getAvailability(@PathVariable Long doctorId) {
        return ResponseEntity.ok(doctorAvailabilityService.getAvailabilityByDoctor(doctorId));
    }
}
