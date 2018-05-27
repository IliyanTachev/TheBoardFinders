package com.example.app.Controllers;

import com.example.app.Repository.UserRepository;
import com.example.app.entity.Role;
import com.example.app.entity.User;
import com.example.app.model.EditUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
//        if(this.userRepository.findOneByUsername(username) == null){
            return "admin/onDelete";
//        }
//        return null;
    }

    @GetMapping("/admin/manage/users/{username}/edit")
        public String editUser(Model model,@PathVariable String username){
            model.addAttribute("user", this.userRepository.findOneByUsername(username));
            model.addAttribute("data",new EditUser());
            List<Role> allRoles = new ArrayList<>(userRepository.findOneByUsername(username).getAuthorities());
            Role role = allRoles.get(0);
            String authority = role.getAuthority();
            if(authority.equals("ROLE_USER")) authority = "USER";
            else if(authority.equals("ROLE_ADMIN")) authority = "ADMIN";
            model.addAttribute("user_authority", authority);
            return "admin/onEdit";
        }

    @PostMapping("/admin/manage/users/{username}/edit")
        public String editedUser(@ModelAttribute EditUser editUser,@PathVariable String username){

        User user =  this.userRepository.findOneByUsername(username);

            if(editUser.getRole() != ""){
                Role updateRole = new Role();
                updateRole.setAuthority(editUser.getRole());
                System.out.println("To Edit" + editUser.getRole());
                Set<Role> set = user.getAuthorities();
                List<Role> roles = new ArrayList<>(set);
                roles.remove(0);
                updateRole.setAuthority(updateRole.getAuthority().toUpperCase());
                if(updateRole.getAuthority().equals("ADMIN")) updateRole.setAuthority("ROLE_ADMIN");
                else if(updateRole.getAuthority().equals("USER")) updateRole.setAuthority("ROLE_USER");
                roles.add(updateRole);
                Set<Role> updatedRoles = new HashSet<>(roles);
                user.setAuthorities(updatedRoles);

            }

            if(editUser.getUsername() != ""){
               user.setUsername(editUser.getUsername());
            }


            if(editUser.getUsername() != "" || editUser.getRole()!="")
                this.userRepository.save(user);

            return "admin/editingInProgress";
        }
}