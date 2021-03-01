package Lab3;

import java.util.HashSet;
import java.util.Set;

public class UserSystem {
    private HashSet<User> users;
    private HashSet<User> authorizedUsers;

    public UserSystem() {
        users = new HashSet<>();
        authorizedUsers = new HashSet<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void authorizeUser(User user) {
        if (users.contains(user)) {
            authorizedUsers.add(user);
        } else {
            System.out.println("User " + user.username + " is not signed up");
        }
    }

    public Set<User> getUsers() {
        return users;
    }

    public Set<User> getAuthorizedUsers() {
        return authorizedUsers;
    }
}
