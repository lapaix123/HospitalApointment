package dev.lapaix.HospitalApointiment.Controller;

import dev.lapaix.HospitalApointiment.model.Appointment;
import dev.lapaix.HospitalApointiment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @GetMapping("/total")
    public long getTotalUsers() {
        return appointmentService.getTotalAppointment();
    }
    @PostMapping("/create")
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment newAppointment = appointmentService.saveAppointment(appointment);
        return new ResponseEntity<>(newAppointment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment != null) {
            return new ResponseEntity<>(appointment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointmentDetails) {
        Appointment updatedAppointment = appointmentService.updateAppointment(id, appointmentDetails);
        if (updatedAppointment != null) {
            return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
