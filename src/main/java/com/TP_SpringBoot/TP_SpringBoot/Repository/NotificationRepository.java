package com.TP_SpringBoot.TP_SpringBoot.Repository;

import com.TP_SpringBoot.TP_SpringBoot.Enum.Role;
import com.TP_SpringBoot.TP_SpringBoot.Model.Notification;
import com.TP_SpringBoot.TP_SpringBoot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
