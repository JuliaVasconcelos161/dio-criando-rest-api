package com.github.juliavasconceloscr161.diocriandorestapi.controller;

import com.github.juliavasconceloscr161.diocriandorestapi.model.User;
import com.github.juliavasconceloscr161.diocriandorestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> getUsers(){
        return repository.findAll();
    }

    @GetMapping("/{username}")
    public User getOne(@PathVariable("username") String username){
        return repository.findByUserName(username);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    @PostMapping
    public void postUser(@RequestBody User user){
        repository.save(user);
    }

    @PutMapping()
    public void putUser(@RequestBody User user){
        repository.save(user);
    }


}
