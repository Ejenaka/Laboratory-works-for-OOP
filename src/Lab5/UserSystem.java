package Lab5;

import java.util.*;

public class UserSystem {
    private final UserDAO usersDb = new UserDAO();
    private List<User> users;

    public UserSystem() {
        users = usersDb.getAll();
    }

    public boolean addUser(User user) {
        if (hasUser(user)) {
            return false;
        }
        users.add(user);
        usersDb.create(user);

        return true;
    }

    private boolean hasUser(User user) {
        Optional<User> userOpt = users
                .stream()
                .filter(u -> u.getUsername().equals(user.getUsername()))
                .findFirst();

        return userOpt.isPresent();
    }

    public List<User> getUsers() {
        return users;
    }
}
