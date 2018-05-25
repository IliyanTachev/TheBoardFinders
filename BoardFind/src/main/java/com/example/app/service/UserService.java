package com.example.app.Service;

import com.example.app.model.RegistrationModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface UserService extends UserDetailsService{
    void register(RegistrationModel registrationModel);
}
