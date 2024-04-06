package com.web3.demo.model;

public record Register(String firstName, String lastName, String username,
                       String email, String password, String walletAddress, String githubLink) {
}
