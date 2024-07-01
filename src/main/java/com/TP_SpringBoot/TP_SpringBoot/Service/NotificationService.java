package com.TP_SpringBoot.TP_SpringBoot.Service;

import com.TP_SpringBoot.TP_SpringBoot.Model.Notification;

public interface NotificationService {
    Notification EnvoyerFormateur(Notification notification);
    void  EnvoyerApprenant(Notification notification);
}
