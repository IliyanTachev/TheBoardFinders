package com.example.app.Controllers;

import com.example.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminPanelController {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
////    private UserRepository eventRepository;

    @GetMapping("/admin/manage/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users",this.userRepository.findAll());
        return "admin/users";
    }

//    @GetMapping("/admin/manage/events")
//    public String getAllEvents(Model model) {
//        model.addAttribute("events",this.eventRepository.findAll());
//        return "admin/events";
//    }

    @GetMapping("/admin/manage/users/{username}")
    public String getUser(Model model, @PathVariable String username){
        model.addAttribute("user_data",this.userRepository.findOneByUsername(username));
        return "admin/manageUser";
    }
}
