package com.example.msusuario.controller;

import com.example.msusuario.entity.User;
import com.example.msusuario.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.list());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findById(id).get());
    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id,
                                          @RequestBody User user) {
        user.setId(id);
        return ResponseEntity.ok(userService.save(user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<User>> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok(userService.list());
    }
}
