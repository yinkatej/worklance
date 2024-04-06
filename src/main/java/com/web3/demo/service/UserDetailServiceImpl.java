package com.web3.demo.service;

import com.web3.demo.entity.User;
import com.web3.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));

        UserBuilder builder = null;
        if (user.isPresent()){
            User currentUser = user.get();
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.roles(currentUser.getRole());
        }else {
            throw new UsernameNotFoundException("user not found");
        }
        return builder.build();
    }
}
