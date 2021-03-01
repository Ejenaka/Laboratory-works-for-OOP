package Lab4;

import Lab3.*;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserSystemTest {
    private final Set<User> testUsers = Set.of(
            new Client("Petrov", "cl1", "pass1"),
            new Client("Ivanov", "cl2", "pass2"),
            new Doctor("Artem", "doc", "pass3")
    );

    private User getTestUserByIndex(int index) {
        return testUsers.toArray(new User[0])[index];
    }

    @Test
    void addUser() {
        UserSystem testUserSystem = new UserSystem();
        User testUser = getTestUserByIndex(0);
        testUserSystem.addUser(testUser);
        assertEquals(testUser, testUserSystem.getUsers().toArray(new User[0])[0]);
    }

    @Test
    void authorizeUser() {
        MedicineStore testMedicineStore = new MedicineStore();
        User testUser = getTestUserByIndex(1);
        signUpAndAuthorizeTestUser(testUser, testMedicineStore);
        User actualAuthorizedUser = testMedicineStore.getUserSystem().getAuthorizedUsers().toArray(new User[0])[0];
        assertEquals(testUser, actualAuthorizedUser);
    }

    private void signUpAndAuthorizeTestUser(User testUser, MedicineStore testMedicineStore) {
        UserSystem testUserSystem = testMedicineStore.getUserSystem();
        try {
            testUser.signUp(testMedicineStore, testUser.getUsername(), testUser.getPassword());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        testUserSystem.addUser(testUser);
        try {
            testUser.authorize(testUser.getUsername(), testUser.getPassword());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void getUsers() {
        MedicineStore testMedicineStore = new MedicineStore();
        testMedicineStore.getUserSystem().getUsers().addAll(testUsers);
        assertEquals(testUsers, testMedicineStore.getUserSystem().getUsers());
    }
}