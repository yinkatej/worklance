package com.web3.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jobDescription;
    private String startDate;
    private String finishDate;
    private String jobTitle;
    private Double price;
    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user")
    private User user;

    public Job(String jobDescription, String jobTitle, String startDate, String finishDate, String token, Double price, User user){}
}
