package souradippatra.Spring_Security_Identity_Server.dto;

import java.util.UUID;

public class UserAccountDTO {

    private UUID id;
    private String username;
    private String role;

    public UserAccountDTO(UUID id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    // Getters
    public UUID getId() { return id; }
    public String getUsername() { return username; }
    public String getRole() { return role; }
}
