package com.example.ms_evento.repository;


import com.example.ms_evento.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByCode(String code);
}
