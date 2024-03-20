    package com.leprechauns.main.Controller;
    
    import java.util.Map;
    
    import io.swagger.v3.oas.annotations.security.SecurityRequirement;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.web.bind.annotation.CrossOrigin;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;
    
    import com.leprechauns.main.security.JWTAuthorizationConfig;
    import com.leprechauns.main.Entity.UserProject;
    import com.leprechauns.main.Service.UserProjectService;
    
    
    @RestController
    @CrossOrigin("*")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public class LoginController {
        @Autowired
        JWTAuthorizationConfig jwtAuthenticationConfig;
    
        @Autowired
        UserProjectService userService;
    
        @PostMapping("/login")
        public UserProject login(
                @RequestParam("user") String username,
                @RequestParam("encryptedPass") String encryptedPass) {
    
            userService.userValidation(username, encryptedPass);
            String token = jwtAuthenticationConfig.getJWTToken(username);
            return new UserProject(username, encryptedPass, token);
        }
    
        @PostMapping("/register")
        public ResponseEntity<Map<Object, Object>> registerUser(
                @RequestParam("user") String username,
                @RequestParam("encryptedPass") String encryptedPass) {

            Map<Object, Object> response = userService.registerUser(new UserProject(username, encryptedPass, null));
            return ResponseEntity.ok(response);

        }
    }