package Lab3;

import java.util.Arrays;
import java.util.HashSet;

public class MedicineStore {
    private static MedicineStore instance;
    private HashSet<Medicine> medicineStorage;

    private MedicineStore() {
        medicineStorage = new HashSet<>();
    }

    private MedicineStore(Medicine[] medicineStorage) {
        this.medicineStorage = new HashSet<>(Arrays.asList(medicineStorage));
    }

    public static MedicineStore getInstance() {
        if (instance == null) {
            return new MedicineStore();
        }
        return instance;
    }

    public static MedicineStore getInstance(Medicine[] medicineStorage) {
        if (instance == null) {
            return new MedicineStore(medicineStorage);
        }
        return instance;
    }

    public Medicine getMedicineByName(String name) {
        return medicineStorage.stream().filter(medicine -> medicine.name.equals(name)).findFirst().get();
    }

    public Medicine getMedicineByPrice(int price) {
        return medicineStorage.stream().filter(medicine -> medicine.price == price).findFirst().get();
    }

    public Medicine getMedicineByProducer(String producer) {
        return medicineStorage.stream().filter(medicine -> medicine.producer.equals(producer)).findFirst().get();
    }

    public Medicine getMedicine(String name, int price, String producer) {
        return medicineStorage.stream()
                .filter(medicine -> medicine.name.equals(name)
                        && medicine.price == price
                        && medicine.producer.equals(producer))
                .findFirst()
                .get();
    }

}
