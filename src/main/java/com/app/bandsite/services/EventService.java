package com.app.bandsite.services;

import com.app.bandsite.model.dtos.EventDto;

import java.util.List;

public interface EventService {

  List<EventDto> findAllEvents();
  List<EventDto> findAllEvents(boolean isCompleteDto);
}
