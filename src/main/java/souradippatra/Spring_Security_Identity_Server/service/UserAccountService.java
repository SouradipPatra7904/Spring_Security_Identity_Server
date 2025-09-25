package souradippatra.Spring_Security_Identity_Server.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import souradippatra.Spring_Security_Identity_Server.dto.UserAccountDTO;

public interface UserAccountService {
    Page<UserAccountDTO> getAllUsers(Pageable pageable);
}

