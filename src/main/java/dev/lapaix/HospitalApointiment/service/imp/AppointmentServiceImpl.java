package dev.lapaix.HospitalApointiment.service.imp;

import dev.lapaix.HospitalApointiment.model.Appointment;
import dev.lapaix.HospitalApointiment.repository.AppointmentRepository;
import dev.lapaix.HospitalApointiment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId).orElse(null);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment updateAppointment(Long appointmentId, Appointment appointment) {
        if (appointmentRepository.existsById(appointmentId)) {
            appointment.setAppointmentId(appointmentId);
            return appointmentRepository.save(appointment);
        }
        return null;
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}