package com.muving;

import com.muving.entities.Role;
import com.muving.entities.User;
import com.muving.entities.UserRol;
import com.muving.repositories.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MuvingBackendApplication implements CommandLineRunner {

    @Autowired
    private UserServices userServices;

    public static void main(String[] args) {
        SpringApplication.run(MuvingBackendApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        User user = new User();

        user.setUsername("Vanesa");
        user.setPassword("1234");
        user.setName("Vanesa");
        user.setLastName("Olivares");
        user.setEmail("prueba@prueba.com");

        Role role = new Role();
        role.setRoleId(1L);
        role.setName("ADMIN");

        Set<UserRol> userRoles = new HashSet<>();
        UserRol userRol = new UserRol();
        userRol.setRole(role);
        userRol.setUser(user);
        userRoles.add(userRol);


        User saveUser = userServices.saveUser(user, userRoles);
        System.out.println(saveUser.getUsername());
    }
}
