package Lab3;

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

    public void signUp(MedicineStore medicineStore, String username, String password) throws Exception {
        if (this.username.equals(username) && this.password.equals(password)) {
            this.medicineStore = medicineStore;
            medicineStore.getUserSystem().addUser(this);
        } else {
            throw new Exception("Username and password don't match");
        }
    }

    public void authorize(String username, String password) throws NullPointerException {
        if (medicineStore == null) {
            throw new NullPointerException("MedicineStore is null, user is not signed up");
        }
        if (this.username.equals(username) && this.password.equals(password)) {
            medicineStore.getUserSystem().authorizeUser(this);
            isAuthorized = true;
        }
    }
}
