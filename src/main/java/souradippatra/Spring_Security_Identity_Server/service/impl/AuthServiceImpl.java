package souradippatra.Spring_Security_Identity_Server.service.impl;

import souradippatra.Spring_Security_Identity_Server.model.UserAccount;
import souradippatra.Spring_Security_Identity_Server.repository.UserAccountRepository;
import souradippatra.Spring_Security_Identity_Server.service.AuthService;

import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository repository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserAccountRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean authenticate(String username, String rawPassword) {
        UserAccount user = repository.findByUsername(username);
        if (user == null) return false;
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }

    @Override
    public UserAccount register(String username, String rawPassword, String role) {
        UserAccount user = new UserAccount();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole(role);
        return repository.save(user);
    }
}
