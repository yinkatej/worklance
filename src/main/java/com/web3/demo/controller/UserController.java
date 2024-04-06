package com.web3.demo.controller;

import com.web3.demo.model.Jobs;
import com.web3.demo.model.Login;
import com.web3.demo.model.Register;
import com.web3.demo.service.JobService;
import com.web3.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private UserService userService;
    private JobService jobService;
    @PostMapping("/register")
    public ResponseEntity<Register> login(@RequestBody Register register){
        userService.register(register);
        return new ResponseEntity<>(register, HttpStatus.CREATED);
    }

    @PostMapping("/jobs")
    public ResponseEntity<?> postJob(Jobs jobs){
        jobService.postJobs(jobs);
        return new ResponseEntity<>("Job posted successfully", HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<?> login(Login login){
       return userService.login(login);

    }
}
