package org.sid.secservice.web;


import lombok.Data;
import org.sid.secservice.entities.Role;
import org.sid.secservice.entities.User;
import org.sid.secservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(path = "/users")
    public List<User> allUsers(){
        return accountService.listUsers();
    }

    @PostMapping(path = "/adduser")
    public User saveUser(@RequestBody User user){
      return accountService.addNewUser(user);
    }

    @PostMapping(path = "/addrole")
    public Role saveRole(@RequestBody Role role){
        return accountService.addNewRole(role);
    }

    @PostMapping(path = "/addRoleToUser")
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
        accountService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getRolename());
    }

}

@Data
class RoleUserForm{
    private String username;
    private String rolename;
}
