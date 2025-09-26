package souradippatra.Spring_Security_Identity_Server.service;

import souradippatra.Spring_Security_Identity_Server.dto.UserAccountDTO;

public interface AuthService {
    boolean authenticate(String username, String rawPassword);
    UserAccountDTO register(String username, String rawPassword, String role);
}

