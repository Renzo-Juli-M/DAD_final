package com.example.msusuario.service;

import com.example.msusuario.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> list();
    Optional<User> findById(Integer id);
    User save(User user);
    User update(User user);
    void delete(Integer id);
}
