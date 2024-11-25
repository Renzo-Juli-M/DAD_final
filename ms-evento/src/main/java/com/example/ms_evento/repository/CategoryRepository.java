package com.example.ms_evento.repository;

import com.example.ms_evento.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByCode(String code);
}
