package com.example.mspago.feign;

import com.example.mspago.dto.InscriptionDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-inscripcion-service", path = "/inscripcion")
public interface InscriptionFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "inscriptionListByIdCB", fallbackMethod = "inscriptionListById")

    public ResponseEntity<InscriptionDto> getById(@PathVariable Integer id);
    default ResponseEntity<InscriptionDto> inscriptionListById(Integer id, Exception e) {
        return ResponseEntity.ok(new InscriptionDto());
    }
}
