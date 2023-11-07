package com.app.bandsite.controllers;

import com.app.bandsite.model.dtos.EventDto;
import com.app.bandsite.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

  private final EventService eventService;

  @Autowired
  public EventController(EventService eventService) {
    this.eventService = eventService;
  }


  @GetMapping
  public String showAllEvents(Model model) {
    List<EventDto> events = eventService.findAllEvents();
    model.addAttribute("events", events);

    return "events";
  }
}
