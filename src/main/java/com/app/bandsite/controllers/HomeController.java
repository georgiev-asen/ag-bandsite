package com.app.bandsite.controllers;

import com.app.bandsite.model.dtos.EventDto;
import com.app.bandsite.repositories.EventRepository;
import com.app.bandsite.repositories.UserRepository;
import com.app.bandsite.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

  private final EventService eventService;

  @Autowired
  public HomeController(EventService eventService, UserRepository userRepository, EventRepository eventRepository, PasswordEncoder passwordEncoder) {
    this.eventService = eventService;
  }

  @GetMapping
  public String index(){
    return "redirect:/home";
  }

  @GetMapping("home")
  public String home(Model model){
    List<EventDto> events = eventService.findAllEvents();

    model.addAttribute("events", events);

    return "index";
  }
}
