package com.web3.demo.repository;

import com.web3.demo.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Job, Long> {

}
