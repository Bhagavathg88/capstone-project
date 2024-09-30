package com.spring.microservices.model;

import lombok.Data;

import java.util.List;

@Data
public class UserOrderDTO {

    public User user;
    public List<UserOrder> orders;

}
