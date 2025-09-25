package souradippatra.Spring_Security_Identity_Server.service;

import souradippatra.Spring_Security_Identity_Server.model.UserAccount;

public interface AuthService {
    boolean authenticate(String username, String rawPassword);
    UserAccount register(String username, String rawPassword, String role);
}

