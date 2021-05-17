package Lab5.Model;

import java.util.Objects;

public abstract class User {
    private int id;
    protected String name;
    protected String username;
    private String password;
    protected MedicineStore medicineStore;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        User other = (User) obj;

        return name.equals(other.name) && username.equals(other.username) &&
                password.equals(other.password) && medicineStore == other.medicineStore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, username, password, medicineStore);
    }
}
