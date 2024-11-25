package com.example.mspago.controller;

import com.example.mspago.dto.ErrorResponseDto;
import com.example.mspago.dto.InscriptionDto;
import com.example.mspago.entity.Pay;
import com.example.mspago.feign.InscriptionFeign;
import com.example.mspago.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pago")
public class PayController {
    @Autowired
    private PayService payService;

    @Autowired
    private InscriptionFeign inscriptionFeign;

    @GetMapping
    public ResponseEntity<List<Pay>> getAll() {
        return ResponseEntity.ok(payService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pay>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(payService.findById(id));
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Pay pay) {
        InscriptionDto inscriptionDto = inscriptionFeign.getById(pay.getInscriptionId()).getBody();

        if (inscriptionDto == null || inscriptionDto.getId() == null) {
            String errorMessage = "Error: Inscripcion no encontrado.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(errorMessage));
        }
        Pay newPay = payService.save(pay);
        return ResponseEntity.ok(newPay);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pay> update(@PathVariable Integer id,
                                       @RequestBody Pay pay) {
        pay.setId(id);
        return ResponseEntity.ok(payService.save(pay));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Pay>> delete(@PathVariable Integer id) {
        payService.delete(id);
        return ResponseEntity.ok(payService.list());
    }
}
