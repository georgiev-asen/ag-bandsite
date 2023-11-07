package com.app.bandsite.repositories;

import com.app.bandsite.model.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
