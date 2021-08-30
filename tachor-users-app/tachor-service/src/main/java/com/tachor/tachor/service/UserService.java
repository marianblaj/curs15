package com.tachor.tachor.service;

import com.tachor.tachor.authentication.appUser.AppUser;
import com.tachor.tachor.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

     UserRepository userRepository;

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

//    public String add(Map<Long, Long> userCart) {
//        userCart
//    }
}
