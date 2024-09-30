package com.spring.microservices.controller;

import com.spring.microservices.model.UserOrder;
import com.spring.microservices.model.UserOrderDTO;
import com.spring.microservices.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class UserOrderController {

    private final UserService userOrderService;

    @PostMapping("/userOrder")
    public UserOrderDTO createUserOrder(@RequestBody UserOrder userOrder){
        return userOrderService.createUserOrder(userOrder);
    }

    @PatchMapping("/userOrder")
    public UserOrderDTO updateUserOrder(@RequestBody UserOrder userOrder){
        return userOrderService.updateUserOrder(userOrder);
    }

    @GetMapping("/userOrders/{id}")
    public UserOrderDTO retrieveUserOrders(@PathVariable String id){
        return userOrderService.retrieveUserOrder(id);
    }



}
