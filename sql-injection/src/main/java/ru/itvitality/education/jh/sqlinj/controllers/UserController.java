package ru.itvitality.education.jh.sqlinj.controllers;

import org.springframework.web.bind.annotation.*;
import ru.itvitality.education.jh.sqlinj.dto.User;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/")
    public List<User> getUsers(){
        return Collections.EMPTY_LIST;
    }

    @PostMapping("/add")
    public User add(@RequestBody User user){
        return user;
    }
}
