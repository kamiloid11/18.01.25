package _180125_;

public class User {
    String login;
    String password;
    Role role;

    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Role UserCheck() {
        if (role == Role.ADMIN || role == Role.USER){
            return role;
        }
        return null;
    }
}