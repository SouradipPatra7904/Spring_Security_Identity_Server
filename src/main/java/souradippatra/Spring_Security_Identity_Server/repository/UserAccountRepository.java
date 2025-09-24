package souradippatra.Spring_Security_Identity_Server.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import souradippatra.Spring_Security_Identity_Server.model.UserAccount;

import java.util.UUID;

@Repository
public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, UUID> {
    // Extra query methods can go here, e.g. findByUsername
    UserAccount findByUsername(String username);
}
