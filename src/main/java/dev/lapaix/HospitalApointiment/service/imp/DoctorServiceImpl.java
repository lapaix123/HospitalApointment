package dev.lapaix.HospitalApointiment.service.imp;

import dev.lapaix.HospitalApointiment.config.PasswordGenerator;
import dev.lapaix.HospitalApointiment.model.Doctor;
import dev.lapaix.HospitalApointiment.model.User;
import dev.lapaix.HospitalApointiment.model.enumeration.Role;
import dev.lapaix.HospitalApointiment.repository.DoctorRepository;
import dev.lapaix.HospitalApointiment.repository.UserRepository;
import dev.lapaix.HospitalApointiment.service.DoctorService;
import dev.lapaix.HospitalApointiment.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public long getTotalDoctors() {
        return doctorRepository.count();
    }
    public Doctor saveDoctor(Doctor doctor) {
        String randomPassword = PasswordGenerator.generateRandomPassword(10);
        User user = new User();
        user.setEmail(doctor.getEmail());
        user.setPassword(passwordEncoder.encode(randomPassword));
        user.setRole(Role.DOCTOR);
        userRepository.save(user);
        if (doctor.getEmail() != null) {
            String toEmail = doctor.getEmail();
            String subject = "Welcome to Hospital Appointment System";
            String body = "Dear Dr. " + doctor.getFirstName() + " " + doctor.getLastName() + ",\n\n"
                    + "We are pleased to inform you that you have been successfully registered as a new doctor in the Hospital Appointment System.\n\n"
                    + "Here are your login details:\n"
                    + "Username: " + doctor.getEmail() + "\n"
                    + "Password: " + randomPassword + "\n\n"
                    + "For your security, please change your password after your first login.\n\n"
                    + "You can log in to the system using the following link: http://localhost:5173/\n\n"
                    + "Should you have any questions or need further assistance, please do not hesitate to contact our support team.\n\n"
                    + "Best regards,\n"
                    + "The Hospital Appointment System Team\n"
                    + "lapaix.dev@gmail.com \n"
                    + "+250 788 965 501";
            emailService.sendEmail(toEmail, subject, body);
        }

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
        Doctor existingDoctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));
        existingDoctor.setFirstName(doctor.getFirstName());
        existingDoctor.setLastName(doctor.getLastName());
        existingDoctor.setEmail(doctor.getEmail());
        existingDoctor.setContactInfo(doctor.getContactInfo());
        existingDoctor.setGender(doctor.getGender());
        existingDoctor.setQualification(doctor.getQualification());
        existingDoctor.setEmploymentStatus(doctor.getEmploymentStatus());
        return doctorRepository.save(existingDoctor);
    }

    @Override
    public void deleteDoctor(Long doctorId) {
        doctorRepository.deleteById(doctorId);
    }
}