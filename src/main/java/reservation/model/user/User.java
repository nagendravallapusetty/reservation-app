package reservation.model.user;

import java.util.List;

public class User {

    private long userId;

    private String userName;

    private List<String> roles;

    private String email;

    public User (long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
