package Lab4;

import Lab3.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UserSystemTest {
    private UserSystem testUserSystem;
    private MedicineStore testMedicineStore;

    private User getTestUserByUsername(String username) {
        Optional<User> userOpt = testUserSystem.getUsers()
                .stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();

        if (userOpt.isPresent()) {
            return userOpt.get();
        }
        throw new NoSuchElementException();
    }

    @BeforeEach
    void setUserSystemAndMedicineStore() {
        testUserSystem = new UserSystem();
        testMedicineStore = new MedicineStore();

    }

    @Test
    void getTestUserByUsername() {
        User expectedUser = new Client("Petrov", "cl1", "pass1");
        User falseUser = new Client("Ivanov", "cl2", "pass2");
        testUserSystem.getUsers().addAll(List.of(expectedUser, falseUser));
        User actualUser = getTestUserByUsername("cl1");

        assertEquals(expectedUser, actualUser);
        assertNotEquals(expectedUser, falseUser);
    }

    @ParameterizedTest
    @MethodSource("testUserProvider")
    void addUser(User testUser) {
        boolean addResult = testUserSystem.addUser(testUser);

        assertTrue(addResult);
        assertEquals(testUser, getTestUserByUsername(testUser.getUsername()));
    }

    private static Stream<User> testUserProvider() {
        return Stream.of(
                new Client("Petrov", "cl1", "pass1"),
                new Client("Ivanov", "cl2", "pass2"),
                new Doctor("Artem", "doc", "pass3")
        );
    }

    @ParameterizedTest
    @MethodSource("testUserProvider")
    void authorizeUser(User testUser) {
        boolean signUpResult = testUser.signUp(testMedicineStore, testUser.getUsername(), testUser.getPassword());
        boolean authorizeResult = testMedicineStore.getUserSystem().authorizeUser(testUser);

        assertTrue(signUpResult);
        assertTrue(authorizeResult);
        assertTrue(testMedicineStore.getUserSystem().getAuthorizedUsers().contains(testUser));
    }
}