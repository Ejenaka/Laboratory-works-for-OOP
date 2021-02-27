package Lab3;

import java.util.ArrayList;

public abstract class User {
    protected String name;
    protected String username;
    private String password;
    private MedicineStore medicineStore;
    protected boolean isAuthorized = false;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public void signUp(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            UserSystem.getInstance().addUser(this);
        }
    }

    public void authorize(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            UserSystem.getInstance().authorizeUser(this);
            isAuthorized = true;
        }
    }
}
