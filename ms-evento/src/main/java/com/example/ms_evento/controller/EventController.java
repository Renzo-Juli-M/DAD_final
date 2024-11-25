package com.example.ms_evento.controller;

import com.example.ms_evento.entity.Event;
import com.example.ms_evento.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;
    @GetMapping
    public ResponseEntity<List<Event>> getAll() {
        return ResponseEntity.ok(eventService.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(eventService.findById(id).get());
    }
    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.save(event));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Event> update(@PathVariable Integer id,
                                          @RequestBody Event event) {
        event.setId(id);
        return ResponseEntity.ok(eventService.save(event));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Event>> delete(@PathVariable Integer id) {
        eventService.delete(id);
        return ResponseEntity.ok(eventService.list());
    }
}
