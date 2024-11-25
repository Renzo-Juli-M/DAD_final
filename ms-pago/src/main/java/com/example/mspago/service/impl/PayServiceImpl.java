package com.example.mspago.service.impl;

import com.example.mspago.entity.Pay;
import com.example.mspago.feign.InscriptionFeign;
import com.example.mspago.repository.PayRepository;
import com.example.mspago.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private PayRepository payRepository;
    @Autowired
    private InscriptionFeign inscriptionFeign;

    @Override
    public List<Pay> list() {
        return payRepository.findAll();
    }
    @Override
    public Optional<Pay> findById(Integer id) {
        Optional<Pay> pay = payRepository.findById(id);
        pay.get().getPays().forEach(payDetail -> {
            payDetail.setInscriptionDto(inscriptionFeign.getById(payDetail.getInscriptionId()).getBody());
        });
        return pay;
    }
    @Override
    public Pay save(Pay pay) {
        return payRepository.save(pay);
    }
    @Override
    public Pay update(Pay pay) {
        return payRepository.save(pay);
    }
    @Override
    public void delete(Integer id) { payRepository.deleteById(id);
    }
}
