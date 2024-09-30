package com.spring.microservices.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID userOrderKey;
    @Column(nullable = false, unique = true)
    public String userId;
    public Long orderId;
    public double orderTotal;
    public String paymentMethod;
    public UUID paymentKey;
    public String status;


}
