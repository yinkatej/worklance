package com.web3.demo.service;

import com.web3.demo.entity.User;
import com.web3.demo.model.Login;
import com.web3.demo.model.Register;
import com.web3.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder;

    public void register(Register register){
        User user = new User();
        String password = encoder.encode(register.password());
        user.setEmail(register.email()); user.setUsername(register.username()); user.setFirstName(register.firstName());
        user.setLastName(register.lastName()); user.setWalletAddress(register.walletAddress());
        user.setPassword(password);
        user.setGithubLink(register.githubLink());
        userRepository.save(user);

    }
    public ResponseEntity<String> login(Login login){
        User user = userRepository.findByUsername(login.username());
        if (encoder.matches(login.password(), user.getPassword())){
            return new ResponseEntity<>("User successfully logged in", HttpStatus.OK);
        }
        return new ResponseEntity<>("No record data", HttpStatus.NOT_FOUND);
    }

}
