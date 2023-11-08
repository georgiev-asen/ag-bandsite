package com.app.bandsite.controllers;

import com.app.bandsite.model.dtos.BandMemberDto;
import com.app.bandsite.model.dtos.EventDto;
import com.app.bandsite.services.BandMemberService;
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
  private final BandMemberService bandMemberService;


  @Autowired
  public HomeController(EventService eventService, PasswordEncoder passwordEncoder, BandMemberService bandMemberService) {
    this.eventService = eventService;
    this.bandMemberService = bandMemberService;
  }

  @GetMapping
  public String index(){
    return "redirect:/home";
  }

  @GetMapping("home")
  public String home(Model model){
    List<EventDto> events = eventService.findAllEvents();
    List<BandMemberDto> bandMembers = bandMemberService.getAllMembers();

    model.addAttribute("events", events);
    model.addAttribute("bandMembers", bandMembers);

    return "index";
  }
}
