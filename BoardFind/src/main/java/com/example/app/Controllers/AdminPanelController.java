package com.example.app.Controllers;

import com.example.app.Repository.UserRepository;
import com.example.app.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @GetMapping("/admin/manage/users/{username}/delete")
    public String deleteUser(@PathVariable String username){
        this.userRepository.delete(this.userRepository.findOneByUsername(username));
        if(this.userRepository.findOneByUsername(username) == null){
            return "admin/onDelete";
        }
        return null;
    }

    @GetMapping("/admin/manage/users/{username}/edit")
        public String editUser(Model model,@PathVariable String username){
            model.addAttribute("user", this.userRepository.findOneByUsername(username));
            List<Role> allRoles = new ArrayList<>(userRepository.findOneByUsername(username).getAuthorities());
            Role role = allRoles.get(0);
            model.addAttribute("user_authority", role.getAuthority());
            return "admin/onEdit";
        }
}
