package com.example.ms_evento.service.impl;

import com.example.ms_evento.entity.Event;
import com.example.ms_evento.repository.EventRepository;
import com.example.ms_evento.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;
    @Override
    public List<Event> list() {
        return eventRepository.findAll();
    }
    @Override
    public Optional<Event> findById(Integer id) {
        return eventRepository.findById(id);
    }
    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }
    @Override
    public Event update(Event event) {
        return eventRepository.save(event);
    }
    @Override
    public void delete(Integer id) {
        eventRepository.deleteById(id);
    }
}
