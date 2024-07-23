package dev.lapaix.HospitalApointiment.service;

import dev.lapaix.HospitalApointiment.model.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment saveAppointment(Appointment appointment);
    Appointment getAppointmentById(Long appointmentId);
    List<Appointment> getAllAppointments();
    Appointment updateAppointment(Long appointmentId, Appointment appointment);
    void deleteAppointment(Long appointmentId);
}
