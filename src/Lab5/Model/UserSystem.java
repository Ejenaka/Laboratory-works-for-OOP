package Lab5.Model;

import Lab5.DAO.UserDAO;

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
        usersDb.create(user);
        usersDb.updateListFromDB(users);

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
