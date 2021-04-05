package Lab4;

import Lab3.*;
import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class MedicineStoreTest {
    private final Medicine[] testMedicines = {
            new Medicine("med1", 100, "prod1", false),
            new Medicine("med2", 200, "prod2", false),
            new Medicine("med3", 300, "prod3", true),
            new Medicine("med1", 200, "someProd", true),
            new Medicine("med2", 200, "prod3", false)
    };

    private MedicineStore testMedicineStore;

    @BeforeEach
    void setTestMedicineStore() {
        testMedicineStore = new MedicineStore();
        testMedicineStore.applyMedicines(testMedicines);
    }

    @Test
    void getMedicineByName() {
        List<Medicine> actualMedicines = testMedicineStore.getMedicineByName("med1");
        List<Medicine> expectedMedicines = List.of(
                new Medicine("med1", 100, "prod1", false),
                new Medicine("med1", 200, "someProd", true)
        );

        assertEquals(expectedMedicines, actualMedicines);
    }

    @Test
    void getMedicineByPrice() {
        List<Medicine> actualMedicines = testMedicineStore.getMedicineByPrice(200);
        List<Medicine> expectedMedicines = List.of(
                new Medicine("med2", 200, "prod2", false),
                new Medicine("med1", 200, "someProd", true),
                new Medicine("med2", 200, "prod3", false)
        );

        assertEquals(expectedMedicines, actualMedicines);
    }

    @Test
    void getMedicineByProducer() {
        List<Medicine> actualMedicines = testMedicineStore.getMedicineByProducer("prod3");
        List<Medicine> expectedMedicines = List.of(
                new Medicine("med3", 300, "prod3", true),
                new Medicine("med2", 200, "prod3", false)
        );

        assertEquals(expectedMedicines, actualMedicines);
    }

    @Test
    void getMedicine() {
        Medicine actualMedicine = testMedicineStore.getMedicine("med1", 200, "someProd");
        Medicine expectedMedicine = testMedicineStore.getMedicine("med1", 200, "someProd");
        assertEquals(expectedMedicine, actualMedicine);
    }
}