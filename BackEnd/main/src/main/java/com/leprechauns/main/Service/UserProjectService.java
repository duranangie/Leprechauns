package com.leprechauns.main.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.leprechauns.main.Entity.UserProject;
import com.leprechauns.main.Entity.DTO.UserProjectDTO;
import com.leprechauns.main.Repository.UserProjectRepository;
import com.leprechauns.main.security.JWTAuthorizationConfig;
import com.leprechauns.main.security.JWTAuthorizationFilter;

@Service
public class UserProjectService {
    
    UserProjectDTO userDTO = new UserProjectDTO();

    @Autowired
    private UserProjectRepository repo;

    @Autowired
    private PasswordEncoder passwordHide;

    @Autowired 
    JWTAuthorizationConfig authorizationConfig;

    @Autowired
    JWTAuthorizationFilter authorizationFilter;

    public UserProjectDTO login(String username, String password){
        UserProject userLogin = repo.findByUser(username).orElse(null);
        if(userLogin != null ){
            if (passwordHide.matches(password, userLogin.getPass())){
                String token = authorizationConfig.getJWTToken(userLogin.getUser());
                userDTO.setUser(username);
                userDTO.setToken(token);
                return userDTO;
            }
        }
        return null;
    }

    public UserProjectDTO register(String username, String password){
        UserProject user = new UserProject();
        user.setUser(username);
        user.setPass(password);
        UserProject response = repo.save(user);
        if (response != null) {
            userDTO.setUser(response.getUser());
            userDTO.setToken(authorizationConfig.getJWTToken(response.getUser()));
            return userDTO;
        }
        return null;    
    }

    public Map<String, Object> validatedToken(String token){
        Boolean access = false;
        Boolean jwtValid = authorizationFilter.isJWTValid(token);
        if (jwtValid) {
            String username = authorizationFilter.getClaims(token).getSubject();
            UserProject userProject = repo.findByUser(username).orElse(null);
        
            if (userProject != null) {
                access = true;
            }
            
        }
        Map<String, Object> responseToken = new HashMap<>();
        responseToken.put("Token is valid", access);
        return responseToken;

    }

}
