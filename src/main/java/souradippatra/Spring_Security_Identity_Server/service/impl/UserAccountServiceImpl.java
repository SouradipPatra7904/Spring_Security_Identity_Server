package souradippatra.Spring_Security_Identity_Server.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import souradippatra.Spring_Security_Identity_Server.dto.UserAccountDTO;
import souradippatra.Spring_Security_Identity_Server.mapper.UserAccountMapper;
import souradippatra.Spring_Security_Identity_Server.repository.UserAccountRepository;
import souradippatra.Spring_Security_Identity_Server.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    /* 
    @Override
    public Page<UserAccountDTO> getAllUsers(Pageable pageable) {
        return repository.findAll(pageable)
                .map(user -> new UserAccountDTO(user.getId(), user.getUsername(), user.getRole()));
    }
    */

    @Override
    public Page<UserAccountDTO> getAllUsers(Pageable pageable){
        return repository.findAll(pageable).map(UserAccountMapper::toDTO);    
    }

}
