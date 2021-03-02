package Lab4;

import Lab3.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    private final List<Medicine> testMedicines = List.of(
            new Medicine("med1", 100, "prod1", false),
            new Medicine("med2", 200, "prod2", false),
            new Medicine("med3", 300, "prod3", true),
            new Medicine("med1", 200, "someProd", true),
            new Medicine("med2", 200, "prod3", false)
    );

    private final Set<User> testUsers = Set.of(
            new Client("Petrov", "cl1", "pass1"),
            new Client("Ivanov", "cl2", "pass2"),
            new Doctor("Artem", "doc", "pass3")
    );

    private User getTestUserByUserName(String username) {
        Optional<User> userOpt = testUsers
                                 .stream()
                                 .filter(user -> user.getUsername().equals(username))
                                 .findFirst();
        if (userOpt.isPresent()) {
            return userOpt.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    private User getTestUserByIndex(int index) {
        return testUsers.toArray(new User[0])[index];
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
    void orderMedicine() {
        MedicineStore testMedicineStore = new MedicineStore();
        Client testClient = (Client) getTestUserByIndex(1);
        signUpAndAuthorizeTestUser(testClient, testMedicineStore);
        try {
            testClient.orderMedicine(testMedicines);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        assertIterableEquals(testMedicines, testClient.uploadOrder());
    }

    @Test
    void editOrder() {
        MedicineStore testMedicineStore = new MedicineStore();
        Client testClient = (Client) getTestUserByIndex(1);
        signUpAndAuthorizeTestUser(testClient, testMedicineStore);
        try {
            testClient.orderMedicine(testMedicines);
            testClient.orderMedicine(new Medicine("testMed", 400, "testProd", false));
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
        Medicine testMedicine = new Medicine("testMed", 400, "testProd", false);
        testClient.editOrder(testMedicine, EditOrderOption.ADD);
        assertEquals(testMedicine, getTestMedicineByName(testClient.uploadOrder(), testMedicine.getName()));
        
    }

    private Medicine getTestMedicineByName(List<Medicine> medicines, String medicineName) {
        Optional<Medicine> medicineOpt = medicines.stream()
                .filter(medicine -> medicine.getName().equals(medicineName))
                .findFirst();
        if (medicineOpt.isPresent()) {
            return medicineOpt.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Test
    void uploadOrder() {
    }
}