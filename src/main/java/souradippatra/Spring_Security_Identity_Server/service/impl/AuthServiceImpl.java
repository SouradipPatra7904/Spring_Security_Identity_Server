package souradippatra.Spring_Security_Identity_Server.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import souradippatra.Spring_Security_Identity_Server.dto.UserAccountDTO;
import souradippatra.Spring_Security_Identity_Server.model.UserAccount;
import souradippatra.Spring_Security_Identity_Server.repository.UserAccountRepository;
import souradippatra.Spring_Security_Identity_Server.service.AuthService;

public class AuthServiceImpl implements AuthService{

    private final UserAccountRepository userRepository;

    public AuthServiceImpl(UserAccountRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserAccount register(String username, String password, String role) {
        UserAccount new_user = new UserAccount(null, username, password, role);
        return userRepository.save(new_user);
    }

    @Override
    public UserAccount login(String username, String password, String role) {
        UserAccount loggedUser = userRepository.findByUsername(username)
                                        .filter(user -> user.getPassword().equals(password))
                                        .orElse(null);
        return loggedUser;
    }

    @Override
    public Page<UserAccountDTO> getAllUsers(Pageable pageable) {
        Page<UserAccount> users = userRepository.findAll(pageable);

        Page<UserAccountDTO> this_page = users.map(user -> new UserAccountDTO(user.getId(), user.getUsername(), user.getRole()));

        return this_page;
    }

}
