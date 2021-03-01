package Lab3;

import java.util.HashSet;
import java.util.Set;

public class UserSystem {
    private Set<User> users;
    private Set<User> authorizedUsers;

    public UserSystem() {
        users = new HashSet<>();
        authorizedUsers = new HashSet<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void authorizeUser(User user) throws Exception {
        if (users.contains(user))
            authorizedUsers.add(user);
        else
            throw new Exception("User " + user.username + " is not signed up");
    }

    public Set<User> getUsers() {
        return users;
    }

    public Set<User> getAuthorizedUsers() {
        return authorizedUsers;
    }
}
