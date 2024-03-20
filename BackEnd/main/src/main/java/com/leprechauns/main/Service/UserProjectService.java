package com.leprechauns.main.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.leprechauns.main.Exceptions.InvalidApplicationException;
import com.leprechauns.main.Exceptions.InvalidTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leprechauns.main.Entity.UserProject;
import com.leprechauns.main.Entity.DTO.UserProjectDTO;
import com.leprechauns.main.Repository.UserProjectRepository;
import com.leprechauns.main.security.JWTAuthorizationConfig;
import com.leprechauns.main.security.JWTAuthorizationFilter;

@Service
public class UserProjectService {



    @Autowired
    UserProjectRepository userRepository;

    @Autowired
    JWTAuthorizationConfig jwtAuthorizationConfig;
    public void userValidation(String username, String password) {
        UserProject user = userRepository.findByUsername(username);
        if (user == null || !user.getEncryptedPass().equalsIgnoreCase(password)) {
            throw new InvalidTokenException("The credentials entered are wrong");
        }
    }

    public Map<Object, Object> registerUser(UserProject user) {
        try {
            userRepository.save(user);
            String token = jwtAuthorizationConfig.getJWTToken(user.getUsername());

            return new LinkedHashMap<>() {{
                put("message", "User has been registered successfully");
                put("token", token);
            }};
        } catch (Exception e) {
            throw new InvalidApplicationException("Username already exists");
        }
    }
}