package Lab3;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserSystem {
    private Set<User> users;
    private Set<User> authorizedUsers;

    public UserSystem() {
        users = new HashSet<>();
        authorizedUsers = new HashSet<>();
    }

    public boolean addUser(User user) {
        if (hasUser(user)) {
            return false;
        }
        users.add(user);
        return true;
    }

    private boolean hasUser(User user) {
        Optional<User> userOpt = users
                .stream()
                .filter(u -> u.getUsername().equals(user.getUsername()))
                .findFirst();

        return userOpt.isPresent();
    }

    public boolean authorizeUser(User user) {
        if (users.contains(user)) {
            authorizedUsers.add(user);
            return true;
        }
        else {
            return false;
        }
    }

    public Set<User> getUsers() {
        return users;
    }

    public Set<User> getAuthorizedUsers() {
        return authorizedUsers;
    }
}
