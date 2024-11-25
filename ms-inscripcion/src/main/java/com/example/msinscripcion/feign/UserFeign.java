package com.example.msinscripcion.feign;

import com.example.msinscripcion.dto.UserDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-usuario-service", path = "/usuario")
public interface UserFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "userListByIdCB", fallbackMethod = "userListById")

    public ResponseEntity<UserDto> getById(@PathVariable Integer id);
    default ResponseEntity<UserDto> userListById(Integer id, Exception e) {
        return ResponseEntity.ok(new UserDto());
    }
}
