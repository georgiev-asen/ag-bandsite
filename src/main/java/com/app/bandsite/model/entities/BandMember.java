package com.app.bandsite.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "band-members")
@Getter
@Setter
public class BandMember {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String bandPosition;

  @Column(nullable = false, columnDefinition = "TEXT")
  private String story;

  @Column(nullable = false)
  private String imgUrl;

}
