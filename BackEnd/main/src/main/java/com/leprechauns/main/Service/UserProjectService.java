package com.leprechauns.main.Service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.leprechauns.main.Exceptions.InvalidApplicationException;
import com.leprechauns.main.Exceptions.InvalidTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leprechauns.main.Entity.UserProject;
import com.leprechauns.main.Repository.UserProjectRepository;

@Service
public class UserProjectService {



    @Autowired
    UserProjectRepository userRepository;


    public void userValidation(String username, String password) {
        UserProject user = userRepository.findByUsername(username);
        if (user == null || !user.getEncryptedPass().equalsIgnoreCase(password)) {
            throw new InvalidTokenException("The credentials entered are wrong");
        }
    }

    public Map<Object, Object> registerUser(UserProject user) {
        try {
            userRepository.save(user);

            return new LinkedHashMap<>() {{
                put("message", "User has been registered successfully");
         
            }};
        } catch (Exception e) {
            throw new InvalidApplicationException("Username already exists");
        }
    }
}