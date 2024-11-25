package com.example.mspago.service;

import com.example.mspago.entity.Pay;

import java.util.List;
import java.util.Optional;

public interface PayService {
    List<Pay> list();
    Optional<Pay> findById(Integer id);
    Pay save(Pay pay);
    Pay update(Pay pay);
    void delete(Integer id);
}
