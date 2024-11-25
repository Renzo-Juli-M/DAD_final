package com.example.msinscripcion.controller;

import com.example.msinscripcion.dto.ErrorResponseDto;
import com.example.msinscripcion.dto.EventDto;
import com.example.msinscripcion.dto.UserDto;
import com.example.msinscripcion.entity.Inscription;
import com.example.msinscripcion.entity.InscriptionDetail;
import com.example.msinscripcion.feign.EventFeign;
import com.example.msinscripcion.feign.UserFeign;
import com.example.msinscripcion.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inscripcion")
public class InscriptionController {
    @Autowired
    private InscriptionService inscriptionService;

    @Autowired
    private UserFeign userFeign;
    @Autowired
    private EventFeign eventFeign;

    @GetMapping
    public ResponseEntity<List<Inscription>> getAll() {
        return ResponseEntity.ok(inscriptionService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscription> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(inscriptionService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Inscription inscription) {
        UserDto userDto = userFeign.getById(inscription.getUserId()).getBody();

        if (userDto == null || userDto.getId() == null) {
            String errorMessage = "Error: Usuario no encontrado.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(errorMessage));
        }
        for (InscriptionDetail inscriptionDetail : inscription.getInscriptionDetails()) {
            EventDto eventDto = eventFeign.getById(inscriptionDetail.getEventId()).getBody();

            if (eventDto == null || eventDto.getId() == null) {
                String errorMessage = "Error: Evento no encontrado.";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(errorMessage));
            }
        }
        Inscription newInscription = inscriptionService.save(inscription);
        return ResponseEntity.ok(newInscription);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscription> update(@PathVariable Integer id,
                                        @RequestBody Inscription inscription) {
        inscription.setId(id);
        return ResponseEntity.ok(inscriptionService.save(inscription));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Inscription>> delete(@PathVariable Integer id) {
        inscriptionService.delete(id);
        return ResponseEntity.ok(inscriptionService.list());
    }
}
