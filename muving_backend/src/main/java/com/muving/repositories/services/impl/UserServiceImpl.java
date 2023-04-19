package com.muving.repositories.services.impl;

import com.muving.entities.User;
import com.muving.entities.UserRol;
import com.muving.repositories.RoleRepository;
import com.muving.repositories.UserRepository;
import com.muving.repositories.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserServices {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User saveUser(User user, Set<UserRol> userRol) throws Exception {
        User userLocal = userRepository.findByUsername(user.getUsername());
        if (userLocal != null) {
            System.out.println("User already exists");
            throw new Exception("User already exists");
        } else {
            for (UserRol userRoles : userRol) {
                roleRepository.save(userRoles.getRole());
            }
            user.getUserRol().addAll(userRol);
            userLocal = userRepository.save(user);
        }
        return userLocal;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userID) {
        userRepository.deleteById(userID);
    }
}
