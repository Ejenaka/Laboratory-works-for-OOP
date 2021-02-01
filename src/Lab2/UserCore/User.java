package Lab2.UserCore;

public abstract class User {
    private String login;
    private String password;
    private String email;
    private long phoneNumber;

    public User(String login, String password, String email, long phoneNumber) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        System.out.println("User constructor");
    }

    public User() {
        System.out.println("User default constructor");
    }

    @Override
    public String toString() {
        return "{ Login: " + login + ", Password: " + password + ", Email: " + email + ", Phone number: " + "+" + phoneNumber;
    }
}
