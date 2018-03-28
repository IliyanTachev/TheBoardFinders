package com.example.app.service.user;

import com.example.app.Models.entity.User;
import com.example.app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean register(String username, String password)
    {
        User user = new User();
        user.setusername(username);
        user.setPassword(password); //new BCryptPasswordEncoder().encode(password)

        return this.userRepository.save(user).getId() != null;
    }
}
