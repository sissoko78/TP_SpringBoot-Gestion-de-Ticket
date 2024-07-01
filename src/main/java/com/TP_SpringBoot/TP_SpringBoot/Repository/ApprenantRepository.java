package com.TP_SpringBoot.TP_SpringBoot.Repository;

import com.TP_SpringBoot.TP_SpringBoot.Model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprenantRepository extends JpaRepository <Apprenant, Long> {
}
