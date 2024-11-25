package com.example.ms_evento.service;

import com.example.ms_evento.entity.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> list();
    Optional<Event> findById(Integer id);
    Event save(Event event);
    Event update(Event event);
    void delete(Integer id);
}
