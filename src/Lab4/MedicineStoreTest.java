package Lab4;

import Lab3.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MedicineStoreTest {
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

    private final MedicineStore testMedicineStore = new MedicineStore(testMedicines.toArray(new Medicine[0]));

    private List<Medicine> getMedicineByIndex(int...indexes) {
        List<Medicine> getResult = new ArrayList<>();
        for (int index : indexes) {
            getResult.add(testMedicines.get(index));
        }
        return getResult;
    }

    private void applyUsersToSystem(MedicineStore medicineStore, Set<User> users) {
        for (User user: users) {
            medicineStore.getUserSystem().addUser(user);
        }
    }

    @Test
    void applyMedicines() {
        MedicineStore medicineStore = new MedicineStore();
        medicineStore.applyMedicines(testMedicines.toArray(new Medicine[0]));
        List<Medicine> actualMedicineStorage = medicineStore.getMedicineStorage();
        assertIterableEquals(testMedicines, actualMedicineStorage);
    }

    @Test
    void getUserSystem() {
        MedicineStore medicineStore = new MedicineStore();
        applyUsersToSystem(medicineStore, testUsers);
        assertEquals(testUsers, medicineStore.getUserSystem().getUsers());
    }

    @Test
    void getMedicineByName() {
        List<Medicine> actualMedicines = testMedicineStore.getMedicineByName("med1");
        List<Medicine> expectedMedicines = getMedicineByIndex(0 ,3);
        assertIterableEquals(expectedMedicines, actualMedicines);
    }

    @Test
    void getMedicineByPrice() {
        List<Medicine> actualMedicines = testMedicineStore.getMedicineByPrice(200);
        List<Medicine> expectedMedicines = getMedicineByIndex(1, 3, 4);
        assertIterableEquals(expectedMedicines, actualMedicines);
    }

    @Test
    void getMedicineByProducer() {
        List<Medicine> actualMedicines = testMedicineStore.getMedicineByProducer("prod3");
        List<Medicine> expectedMedicines = getMedicineByIndex(2, 4);
        assertIterableEquals(expectedMedicines, actualMedicines);

    }

    @Test
    void getMedicine() {
        Medicine actualMedicine = testMedicines.get(3);
        Medicine expectedMedicine = testMedicineStore.getMedicine("med1", 200, "someProd");
        assertEquals(expectedMedicine, actualMedicine);
    }
}