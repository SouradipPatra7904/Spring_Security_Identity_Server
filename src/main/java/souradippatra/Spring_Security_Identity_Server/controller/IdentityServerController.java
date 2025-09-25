package souradippatra.Spring_Security_Identity_Server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class IdentityServerController {

    @GetMapping("/.well-known/openid-configuration")
    public Map<String, Object> openIdConfig() {
        return Map.of(
                "issuer", "http://localhost:8080",
                "token_endpoint", "http://localhost:8080/oauth2/token",
                "jwks_uri", "http://localhost:8080/oauth2/jwks",
                "grant_types_supported", new String[]{"client_credentials"},
                "scopes_supported", new String[]{"read", "write"}
        );
    }
}
