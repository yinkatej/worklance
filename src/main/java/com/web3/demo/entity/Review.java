package com.web3.demo.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String review;
    private int rating;

    @ManyToOne(cascade = CascadeType.ALL)
    private User reviewer;

    @OneToOne
    private User developer;

    @OneToOne
    private Job job;
}
