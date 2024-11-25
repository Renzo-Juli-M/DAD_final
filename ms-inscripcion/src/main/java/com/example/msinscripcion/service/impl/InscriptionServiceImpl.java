package com.example.msinscripcion.service.impl;

import com.example.msinscripcion.entity.Inscription;
import com.example.msinscripcion.feign.EventFeign;
import com.example.msinscripcion.feign.UserFeign;
import com.example.msinscripcion.repository.InscriptionRepository;
import com.example.msinscripcion.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionServiceImpl implements InscriptionService {
    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private EventFeign eventFeign;
    @Autowired
    private UserFeign userFeign;

    @Override
    public List<Inscription> list() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription save(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Optional<Inscription> findById(Integer id) {
        Optional<Inscription> inscription = inscriptionRepository.findById(id);
        inscription.get().setUserDto(userFeign.getById(inscription.get().getUserId()).getBody());

        inscription.get().getInscriptionDetails().forEach(inscriptionDetail -> {
            inscriptionDetail.setEventDto(eventFeign.getById(inscriptionDetail.getEventId()).getBody());
        });
        return inscription;
    }

    @Override
    public void delete(Integer id) {
        inscriptionRepository.deleteById(id);
    }

    @Override
    public Inscription update(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }
}
