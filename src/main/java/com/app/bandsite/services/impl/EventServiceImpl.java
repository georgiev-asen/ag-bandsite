package com.app.bandsite.services.impl;

import com.app.bandsite.model.dtos.EventDto;
import com.app.bandsite.model.entities.Event;
import com.app.bandsite.repositories.EventRepository;
import com.app.bandsite.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

  private final EventRepository eventRepository;

  @Autowired
  public EventServiceImpl(EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  @Override
  public List<EventDto> findAllEvents() {
    return findAllEvents(false);
  }

  @Override
  public List<EventDto> findAllEvents(boolean isCompleteDto) {
    List<Event> events = eventRepository.findAll();

    if (events.size() == 0) return new ArrayList<EventDto>();

    return events.stream().map(event -> mapEventToDto(event, isCompleteDto)).toList();
  }


  private EventDto mapEventToDto(Event event, boolean isCompleteDto) {
    EventDto dto = new EventDto();
    dto.setTitle(event.getTitle());
    dto.setEventDate(event.getEventDate());
    dto.setAdmission(event.getAdmission());
    dto.setImgUrl(event.getImgUrl());

    if (isCompleteDto) dto.setDescription(event.getDescription());

    return dto;
  }
}
