package com.leprechauns.main.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leprechauns.main.security.JWTAuthorizationConfig;
import com.leprechauns.main.Entity.UserProject;
import com.leprechauns.main.Entity.DTO.UserProjectDTO;
import com.leprechauns.main.Service.UserProjectService;

@RestController
public class LoginController {

    @Autowired
    private UserProjectService service;
    
    @Autowired
    JWTAuthorizationConfig jwtAuthtenticationConfig;

    @PostMapping("login")
    public ResponseEntity<?> login(
            @RequestParam("user") String user,
            @RequestParam("password") String password) {
        
        UserProjectDTO dto = service.login(user, password);

        if (dto == null){
            throw new UsernameNotFoundException("That user doesn't exist");
        }
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("register")
    public ResponseEntity<?> register(
            @RequestParam("user") String user,
            @RequestParam("password") String password){

        UserProjectDTO dto = service.register(user, password);

        if(dto == null){
            throw new Error("Sorry, the user can't created");
        }
        return ResponseEntity.ok(dto);
    }

    
    @PostMapping("validToken")
    public ResponseEntity<?> validToken(
        @RequestParam("token") String token){
            Map<String, Object> validToken = service.validatedToken(token);
            return ResponseEntity.ok(validToken);
        }

}
