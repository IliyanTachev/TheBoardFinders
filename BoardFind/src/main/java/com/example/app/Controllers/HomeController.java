package com.example.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage(){
        return "home/index";
    }

    @RequestMapping(value = "/user/aboutUs", method = RequestMethod.GET)
    public String getAboutUsPage(){
        return "home/aboutUs";
    }

    @GetMapping("/user/eventsAndPeople/ContactUs")
    public String getContactUsPage(){
        return "home/contactUs";
    }
}
