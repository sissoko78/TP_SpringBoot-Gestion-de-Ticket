package com.TP_SpringBoot.TP_SpringBoot.Service;

import com.TP_SpringBoot.TP_SpringBoot.Model.Admin;

import java.util.List;

public interface AdminService {

    Admin CreerAdmin(Admin admin);

    List<Admin> lire();

    Admin modifyAdmin( Long Id ,Admin admin);

    String deleteAdmin(Long Id);
}
