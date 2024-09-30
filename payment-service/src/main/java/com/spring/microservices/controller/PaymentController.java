package com.spring.microservices.controller;

import com.spring.microservices.model.Payment;
import com.spring.microservices.model.Payments;
import com.spring.microservices.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/payment")
    public Payments processPayment(@RequestBody Payment payment){
        return paymentService.processPayment(payment);
    }

    @GetMapping("/payment/{orderId}")
    public Payments retrievePayment(@PathVariable Long orderId){
        return paymentService.retrievePayment(orderId);
    }

    @GetMapping("/payments")
    public List<Payments> retrieveAllPayments(){
        return paymentService.retrieveAllPayments();
    }

    @GetMapping("/payments/{userId}")
    public List<Payments> retrievePaymentByUserId(@PathVariable String userId){
        return paymentService.retrievePaymentByUserId(userId);
    }
}
