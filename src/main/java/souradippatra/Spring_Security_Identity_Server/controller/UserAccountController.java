package souradippatra.Spring_Security_Identity_Server.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import souradippatra.Spring_Security_Identity_Server.dto.UserAccountDTO;

import org.springframework.data.domain.Pageable;
import souradippatra.Spring_Security_Identity_Server.service.UserAccountService;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    /**
     * Example: GET /api/users?page=0&size=5&sort=username,asc
     */
    @GetMapping
    public Page<UserAccountDTO> listUsers(Pageable pageable) {
        return service.getAllUsers(pageable);
    }
}
