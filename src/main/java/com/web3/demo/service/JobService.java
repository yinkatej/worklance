package com.web3.demo.service;

import com.web3.demo.entity.Job;
import com.web3.demo.entity.User;
import com.web3.demo.model.Jobs;
import com.web3.demo.repository.JobsRepository;
import com.web3.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService {
    private JobsRepository jobsRepository;
    private UserRepository userRepository;

    public void postJobs(Jobs jobs){
        User user = (userRepository.findByUsername(""));
        jobsRepository.save(new Job(jobs.description(),jobs.title(),jobs.start(),jobs.end(),jobs.token(),jobs.price(), user));
    }
}
