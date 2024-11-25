package com.example.msinscripcion.service;

import com.example.msinscripcion.entity.Inscription;

import java.util.List;
import java.util.Optional;

public interface InscriptionService {
    public List<Inscription> list();
    public Inscription save(Inscription inscription);
    public Optional<Inscription> findById(Integer id);
    public void delete(Integer id);
    public Inscription update(Inscription inscription);
}
