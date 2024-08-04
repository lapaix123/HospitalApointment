package dev.lapaix.HospitalApointiment.service.imp;

import dev.lapaix.HospitalApointiment.config.PasswordGenerator;
import dev.lapaix.HospitalApointiment.model.Nurse;
import dev.lapaix.HospitalApointiment.model.User;
import dev.lapaix.HospitalApointiment.model.enumeration.Role;
import dev.lapaix.HospitalApointiment.repository.NurseRepository;
import dev.lapaix.HospitalApointiment.repository.UserRepository;
import dev.lapaix.HospitalApointiment.service.EmailService;
import dev.lapaix.HospitalApointiment.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseServiceImpl implements NurseService {

    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public long getTotalNurses() {
        return nurseRepository.count();
    }

    @Override
    public Nurse saveNurse(Nurse nurse) {
        String randomPassword = PasswordGenerator.generateRandomPassword(10);
        User user = new User();
        user.setEmail(nurse.getEmail());
        user.setPassword(passwordEncoder.encode(randomPassword));
        user.setRole(Role.NURSE);
        userRepository.save(user);
        if (nurse.getEmail() != null) {
            String toEmail = nurse.getEmail();
            String subject = "Welcome to Hospital Appointment System";
            String body = "Dear Nurse " + nurse.getFirstName() + " " + nurse.getLastName() + ",\n\n"
                    + "We are pleased to inform you that you have been successfully registered as a new nurse in the Hospital Appointment System.\n\n"
                    + "Here are your login details:\n"
                    + "Username: " + nurse.getEmail() + "\n"
                    + "Password: " + randomPassword + "\n\n"
                    + "For your security, please change your password after your first login.\n\n"
                    + "You can log in to the system using the following link: http://localhost:5173/\n\n"
                    + "Should you have any questions or need further assistance, please do not hesitate to contact our support team.\n\n"
                    + "Best regards,\n"
                    + "The Hospital Appointment System Team\n"
                    + "lapaix.dev@gmail.com \n"
                    + "+250 788 965 501";
            // Send email
            emailService.sendEmail(toEmail, subject, body);
        }

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