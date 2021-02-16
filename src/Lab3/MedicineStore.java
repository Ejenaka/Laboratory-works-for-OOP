package Lab3;

import java.util.*;
import java.util.stream.Stream;

public class MedicineStore {
    private static MedicineStore instance;
    private ArrayList<Medicine> medicineStorage;

    private MedicineStore() {
        medicineStorage = new ArrayList<>();
    }

    private MedicineStore(Medicine[] medicineStorage) {
        this.medicineStorage = new ArrayList<>(Arrays.asList(medicineStorage));
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

    public List<Medicine> getMedicineByName(String name) {
        Object[] medicines = medicineStorage.stream().filter(medicine -> medicine.name.equals(name)).toArray();
        if (medicines == null) {
            throw new NullPointerException("Medicines not find");
        }

    }

    public List<Medicine> getMedicineByPrice(int price) {
        return medicineStorage.stream().filter(medicine -> medicine.price == price).findFirst().get();
    }

    public List<Medicine> getMedicineByProducer(String producer) {
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
