package Lab3;

import java.util.HashSet;

public class UserSystem {
    private static UserSystem instance;
    private HashSet<User> users;
    private HashSet<User> authorizedUsers;

    private UserSystem() {
        users = new HashSet<>();
        authorizedUsers = new HashSet<>();
    }

    public static UserSystem getInstance() {
        if (instance == null) {
            return new UserSystem();
        }
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void authorizeUser(User user) {
        if (users.contains(user)) {
            authorizedUsers.add(user);
        } else {
            System.out.println("This user is not signed up");
        }
    }

}
