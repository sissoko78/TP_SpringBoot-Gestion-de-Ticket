package com.TP_SpringBoot.TP_SpringBoot.Security;

import com.TP_SpringBoot.TP_SpringBoot.Model.User;
import com.TP_SpringBoot.TP_SpringBoot.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String Username) throws UsernameNotFoundException {
        Optional<User> user= Optional.ofNullable(userRepository.findByUsername(Username));
        if (user.isPresent()) {
            var userObj=user.get();
            Collection<GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_"+userObj.getRole().name()));
            return new org.springframework.security.core.userdetails.User(
                    userObj.getUsername(),
                    userObj.getPassword(),
                    authorities);

        }else {
            throw new UsernameNotFoundException(Username);
        }
    }
}
