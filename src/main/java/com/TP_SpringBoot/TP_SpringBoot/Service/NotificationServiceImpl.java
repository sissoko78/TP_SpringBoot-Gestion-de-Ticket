package com.TP_SpringBoot.TP_SpringBoot.Service;

import com.TP_SpringBoot.TP_SpringBoot.Model.Notification;
import com.TP_SpringBoot.TP_SpringBoot.Model.User;
import com.TP_SpringBoot.TP_SpringBoot.Repository.NotificationRepository;
import com.TP_SpringBoot.TP_SpringBoot.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.TP_SpringBoot.TP_SpringBoot.Enum.Role.Formateur;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private NotificationRepository notificationRepository;
    private UserRepository userRepository;


    private JavaMailSender mailSender;

    @Override
    public Notification EnvoyerFormateur(Notification notification) {
        List<User> formateurs = userRepository.findAllByRole(Formateur);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(notification.getTitre() + " - Nouveau Ticket");
        message.setText("Un nouveau ticket a été soumis :\n\n" + notification.getCorps());
        formateurs.forEach(formateur -> {
            message.setTo(formateur.getEmail());
        });
        mailSender.send(message);
        return notificationRepository.save(notification);

    }

    @Override
    public void EnvoyerApprenant(Notification notification) {

    }


}
