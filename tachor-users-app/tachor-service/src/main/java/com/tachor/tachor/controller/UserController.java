package com.tachor.tachor.controller;

import com.tachor.tachor.authentication.appUser.AppUser;
import com.tachor.tachor.authentication.appUser.AppUserService;
import com.tachor.tachor.repository.UserRepository;
import com.tachor.tachor.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping()
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;
    private final AppUserService appUserService;
    private final UserService userService;

    @GetMapping("/user")
//    @CrossOrigin(origins = "http://localhost:4200")
    public String user(){
        return "User";
    }

    @PostMapping("/admin")
    public String adminPost(){
        return "AdminPost";
    }

    @GetMapping("/admin")
    public String adminGet(){
        return "AdminGet";
    }

    @GetMapping("/users")
    public List<AppUser> getAllUsers(){
        return userService.getAllUsers();
    }

//    @PostMapping
//    public String addUserCart(@RequestBody Map<Long, Long> userCart){
//        return userService.add(userCart);
//    }

}

