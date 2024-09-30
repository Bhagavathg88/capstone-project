package com.spring.microservices.repository;

import com.spring.microservices.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Long> {

    public Payments findByOrderId(Long orderId);
    public List<Payments> findByUserId(String userId);
}
