package com.spring.microservices.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID userKey;

    @Column(nullable = false, unique = true)
    public String userId;
    public String firstName;
    public String lastName;
    public String emailId;
    public String address1;
    public String address2;
    public String city;
    public String state;
    public Integer zipCode;

}

