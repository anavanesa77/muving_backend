package com.muving.repositories.services;

import com.muving.entities.User;
import com.muving.entities.UserRol;

import java.util.Set;

public interface UserServices {

    public User saveUser (User user, Set<UserRol> userRol) throws Exception;

    public User getUser (String username);

    public void deleteUser (Long userID);


}
