package com.web3.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String services;
    private String deadline;
    @Lob
    private byte[] data;
    private Double payment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobApplication")
    private List<User> users;


}
