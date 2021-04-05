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

class ClientTest {
    private MedicineStore testMedicineStore;
    private Client testClient;

    @BeforeEach
    void setMedicineStore() {
         testMedicineStore = new MedicineStore();
         testClient = new Client("Petrov", "cl1", "pass1");
         testClient.signUp(testMedicineStore, testClient.getUsername(), testClient.getPassword());
         testClient.authorize(testClient.getUsername(), testClient.getPassword());
    }

    @ParameterizedTest
    @MethodSource("testMedicineProvider")
    void orderMedicine(Medicine medicine) {
        testClient.orderMedicine(medicine);

        assertTrue(testClient.uploadOrder().contains(medicine));
    }

    private static Stream<Medicine> testMedicineProvider() {
        return Stream.of(
                new Medicine("med1", 100, "prod1", false),
                new Medicine("med2", 200, "prod2", false),
                new Medicine("med3", 300, "prod3", true),
                new Medicine("med1", 200, "someProd", true),
                new Medicine("med2", 200, "prod3", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testMedicineProvider")
    void editOrder(Medicine medicine)  {
        testClient.editOrder(medicine, EditOrderOption.ADD);
        assertTrue(testClient.uploadOrder().contains(medicine));

        testClient.editOrder(medicine, EditOrderOption.REMOVE);
        assertFalse(testClient.uploadOrder().contains(medicine));

        testClient.editOrder(medicine, EditOrderOption.CLEAR);
        assertTrue(testClient.uploadOrder().isEmpty());
    }
}