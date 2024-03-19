package com.leprechauns.main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leprechauns.main.security.JWTAuthorizationConfig;
import com.leprechauns.main.Entity.UserProject;

@RestController
public class LoginController {
    
    @Autowired
    JWTAuthorizationConfig jwtAuthtenticationConfig;

    @PostMapping("login")
    public UserProject login(
            @RequestParam("user") String user,
            @RequestParam("encryptedPass") String password) {
                
        

        String token = jwtAuthtenticationConfig.getJWTToken(user);
        return new UserProject(user, password, token);
    }
}
