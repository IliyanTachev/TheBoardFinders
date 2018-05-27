package com.example.app.Controllers;

import com.example.app.Service.EventService;
import com.example.app.model.RegistrationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class EventsController {

    @Autowired
    private EventService eventService;

    @GetMapping("/user/eventsAndPeople/registerEvent")
    public String getRegisterPage(Model model, RegistrationEvent registrationEvent){
            model.addAttribute("event", registrationEvent);
            return "events/registerEvent";
    }

    @PostMapping("/user/eventsAndPeople/registerEvent")
    public String registerEvent(@Valid @ModelAttribute RegistrationEvent registrationEvent){
        this.eventService.register(registrationEvent);
        return "events/registerEvent";
    }

    @RequestMapping(value = "/user/eventsAndPeople", method = RequestMethod.GET)
    public String getEventsAndPeoplePage(){
        return "home/eventsAndPeople";
    }
}
