package Lab3;

import java.util.Objects;

public abstract class User {
    protected String name;
    protected String username;
    private String password;
    protected MedicineStore medicineStore;
    protected boolean isAuthorized = false;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean signUp(MedicineStore medicineStore, String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            this.medicineStore = medicineStore;
            medicineStore.getUserSystem().addUser(this);
            return true;
        }
        return false;
    }

    public boolean authorize(String username, String password) {
        if (medicineStore == null) {
            return false;
        }
        if (this.username.equals(username) && this.password.equals(password)) {
            medicineStore.getUserSystem().authorizeUser(this);
            isAuthorized = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        User other = (User) obj;

        return name.equals(other.name) && username.equals(other.username) &&
                password.equals(other.password) && medicineStore == other.medicineStore &&
                isAuthorized == other.isAuthorized;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, username, password, medicineStore, isAuthorized);
    }
}
