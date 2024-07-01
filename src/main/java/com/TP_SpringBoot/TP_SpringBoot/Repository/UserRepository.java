package com.TP_SpringBoot.TP_SpringBoot.Repository;

import com.TP_SpringBoot.TP_SpringBoot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository <User,Long> {
    User findByUsername(String Username);


    List<User> findAllByRole(Enum formateur);
}
