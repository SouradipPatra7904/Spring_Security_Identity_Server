package souradippatra.Spring_Security_Identity_Server.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import souradippatra.Spring_Security_Identity_Server.service.AuthService;
import souradippatra.Spring_Security_Identity_Server.model.UserAccount;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username,
                                        @RequestParam String password) {
        boolean success = authService.authenticate(username, password);
        if (success) {
            return ResponseEntity.ok("Login successful!");
        }
        return ResponseEntity.status(401).body("Invalid credentials.");
    }

    @PostMapping("/register")
    public ResponseEntity<UserAccount> register(@RequestParam String username,
                                                @RequestParam String password,
                                                @RequestParam(defaultValue = "USER") String role) {
        UserAccount created = authService.register(username, password, role);
        return ResponseEntity.ok(created);
    }
}

