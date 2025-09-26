package souradippatra.Spring_Security_Identity_Server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

@SpringBootTest
@ActiveProfiles("test") // activate the H2 test profile
class SpringSecurityIdentityServerApplicationTests {

    // Optional: mock the repository if you only want context load test
    @MockBean
    private RegisteredClientRepository registeredClientRepository;

    @Test
    void contextLoads() {
        // context will load with H2 DB, migrations applied
    }
}
