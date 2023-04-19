package com.muving.controller;

import com.muving.entities.Role;
import com.muving.entities.User;
import com.muving.entities.UserRol;
import com.muving.repositories.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping ("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) throws Exception{
        Set<UserRol> rol = new HashSet<>();
        Role role = new Role();
        role.setRoleId(2L);

        role.setName("Prueba2");

        UserRol userRol = new UserRol();
        userRol.setUser(user);
        userRol.setRole(role);

        return userServices.saveUser(user,rol);
    }

    @GetMapping ("/{username}")
    public User getUser (@PathVariable ("username") String username){
        return userServices.getUser(username);
    }

    @DeleteMapping ("/{userID}")
    public void deleteUser (@PathVariable ("userID") Long userID){
        userServices.deleteUser(userID);
    }

}
