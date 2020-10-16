package ru.itvitality.education.jh.sqlinj.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itvitality.education.jh.sqlinj.dao.UserDao;
import ru.itvitality.education.jh.sqlinj.dto.User;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserDao userDao;

    @GetMapping("/")
    public List<User> getUsers(){
        return userDao.getUsers();
    }

    @GetMapping("/get")
    public User getUser(@RequestParam Integer id){
        return userDao.getById( id );
    }

    @GetMapping("/find")
    public List<User> getUser(@RequestParam String name){
        return userDao.getByName( name );
    }

    @PostMapping("/update")
    public User update(@RequestBody User user){
        return userDao.update( user );
    }
}
