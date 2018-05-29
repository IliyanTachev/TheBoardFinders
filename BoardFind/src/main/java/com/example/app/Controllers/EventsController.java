package com.example.app.Controllers;

import com.example.app.Service.EventService;
import com.example.app.model.RegistrationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

        import javax.validation.Valid;

@Controller
public class EventsController {

    @Autowired
    private EventService eventService;

    @GetMapping("/user")
    public ModelAndView getRegisterPage(){
        return new ModelAndView("redirect:/user/eventsAndPeople");
    }

    @GetMapping("/user/eventsAndPeople/registerEvent")
    public String getRegisterPage(Model model){
        model.addAttribute("event", new RegistrationEvent());
        return "events/registerEvent";
    }

    @PostMapping("/user/eventsAndPeople/registerEvent")
    public String registerEvent(@ModelAttribute RegistrationEvent registrationEvent){
//        if(bindingResult.hasErrors()) {
//            return "events/registerEvent";
//        }
        this.eventService.register(registrationEvent);
        return "events/registerEvent";
    }

    @RequestMapping(value = "/user/eventsAndPeople", method = RequestMethod.GET)
    public String getEventsAndPeoplePage(){
        return "home/eventsAndPeople";
    }

}
