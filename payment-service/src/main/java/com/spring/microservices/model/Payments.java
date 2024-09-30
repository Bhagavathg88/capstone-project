package com.spring.microservices.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID paymentKey;
    private Long orderId;
    private Double paymentAmount;
    private String paymentMethod;
    private String paymentStatus;
    private String statusReason;
    private Instant paymentDate;
    private String userId;
}
