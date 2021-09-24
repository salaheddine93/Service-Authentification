package org.sid.secservice.service;

import org.sid.secservice.dao.RoleRepo;
import org.sid.secservice.dao.UserRepo;
import org.sid.secservice.entities.Role;
import org.sid.secservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private UserRepo userRepo;
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AccountServiceImpl(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }


    @Override
    public User addNewUser(User user) {
        String pw = user.getPassword();
        user.setPassword(passwordEncoder.encode(pw));
        return userRepo.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByRolename(rolename);
        user.getRoles().add(role);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> listUsers() {
        return userRepo.findAll();
    }
}
