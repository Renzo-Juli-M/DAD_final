package com.example.mspago.repository;

import com.example.mspago.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayRepository extends JpaRepository<Pay, Integer> {
}
