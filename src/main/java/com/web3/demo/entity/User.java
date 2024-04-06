package com.web3.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    @Column(unique = true)
    private String username;
    private String walletAddress;
    private String githubLink;
    private String role;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Job> jobList;

    @ManyToOne(fetch = FetchType.LAZY)
    private JobApplication jobApplication;
}
