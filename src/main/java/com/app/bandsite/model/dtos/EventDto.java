package com.app.bandsite.model.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EventDto {
  private LocalDate eventDate;

  private String title;

  private String description;

  private String imgUrl;

  private Float admission;
}
