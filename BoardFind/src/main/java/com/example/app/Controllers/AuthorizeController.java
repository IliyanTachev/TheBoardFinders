package com.example.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorizeController {

    @GetMapping("/unauthorized")
    public String getUnauthorizedPage(){
        return "unauthorized";
    }
}
