package com.TP_SpringBoot.TP_SpringBoot;

import com.TP_SpringBoot.TP_SpringBoot.Enum.Role;
import com.TP_SpringBoot.TP_SpringBoot.Model.Admin;
import com.TP_SpringBoot.TP_SpringBoot.Service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.Scanner;

@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class })
public class TpSpringBootApplication {


	public static void main(String[] args) {
		SpringApplication.run(TpSpringBootApplication.class, args);
	}
}
