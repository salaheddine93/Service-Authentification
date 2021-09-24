package org.sid.secservice.service;

import org.sid.secservice.entities.Role;
import org.sid.secservice.entities.User;

import java.util.List;

public interface AccountService {

    User addNewUser (User user);
    Role addNewRole (Role role);
    void addRoleToUser (String username, String rolename);
    User loadUserByUsername (String username);
    List<User> listUsers();

}
