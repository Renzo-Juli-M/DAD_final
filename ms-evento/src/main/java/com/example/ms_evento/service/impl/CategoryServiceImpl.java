package com.example.ms_evento.service.impl;

import com.example.ms_evento.entity.Category;
import com.example.ms_evento.repository.CategoryRepository;
import com.example.ms_evento.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> list() {
        return categoryRepository.findAll();
    }
    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }
    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }

}
