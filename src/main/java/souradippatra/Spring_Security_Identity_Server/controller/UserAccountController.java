package souradippatra.Spring_Security_Identity_Server.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import souradippatra.Spring_Security_Identity_Server.service.AuthService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import souradippatra.dto.UserAccountDTO;
import souradippatra.service.UserAccountService;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final AuthService service;

    public UserAccountController(AuthService service) {
        this.service = service;
    }

    // Example: GET /api/users?page=0&size=5
    @GetMapping
    public Page<UserAccountDTO> listUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return service.getAllUsers(PageRequest.of(page, size));
    }
}
