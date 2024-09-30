package com.spring.microservices.repository;

import com.spring.microservices.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {

    public List<UserOrder> findByUserId(String userId);
    public UserOrder  findByOrderId(Long orderId);
}
