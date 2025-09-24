package souradippatra.Spring_Security_Identity_Server.service;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import souradippatra.Spring_Security_Identity_Server.model.UserAccount;
import souradippatra.Spring_Security_Identity_Server.dto.UserAccountDTO;


public interface AuthService {
    UserAccount register(String username, String password, String role);
    UserAccount login(String username, String password, String role);
    Page<UserAccountDTO> getAllUsers(Pageable pageable);
}
