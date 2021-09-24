package org.sid.secservice;

import org.sid.secservice.entities.Role;
import org.sid.secservice.entities.User;
import org.sid.secservice.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecServiceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {

            accountService.addNewUser(new User(null,"SalahEddine","1234567",new ArrayList<>()));
            accountService.addNewUser(new User(null,"Nohaila","1234567",new ArrayList<>()));
            accountService.addNewUser(new User(null,"Mohammed","1234567",new ArrayList<>()));

            accountService.addNewRole(new Role(null,"ADMIN"));
            accountService.addNewRole(new Role(null,"USER"));
            accountService.addNewRole(new Role(null,"CUSTOMER_MANAGER"));
            accountService.addNewRole(new Role(null,"PRODUCT_MANAGER"));
            accountService.addNewRole(new Role(null,"BILLS_MANAGER"));

            accountService.addRoleToUser("SalahEddine","ADMIN");
            accountService.addRoleToUser("SalahEddine","CUSTOMER_MANAGER");
            accountService.addRoleToUser("Nohaila","BILLS_MANAGER");
            accountService.addRoleToUser("Mohammed","PRODUCT_MANAGER");

        };
    }

}
