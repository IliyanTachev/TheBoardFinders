package com.example.app.Controllers;

import com.example.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPanelController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin/allUsers")
    public String getAllUsers(Model model) {
        model.addAttribute("users",this.userRepository.findAll());
        return "admin/allUsers";
    }
}
