package Lab3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MedicineStore {
    private ArrayList<Medicine> medicineStorage;

    public MedicineStore() {
        medicineStorage = new ArrayList<>();
    }

    public MedicineStore(Medicine[] medicineStorage) {
        this.medicineStorage = new ArrayList<>(Arrays.asList(medicineStorage));
    }

    public List<Medicine> getMedicineByName(String name) throws NoSuchElementException {
        List<Medicine> searchResult = medicineStorage.stream()
                .filter(medicine -> medicine.name.equals(name))
                .collect(Collectors.toList());

        if (!searchResult.isEmpty()) {
            return searchResult;
        } else {
            throw new NoSuchElementException("Couldn't find these medicines");
        }

    }

    public List<Medicine> getMedicineByPrice(int price) throws NoSuchElementException {
        List<Medicine> searchResult = medicineStorage.stream()
                .filter(medicine -> medicine.price == price)
                .collect(Collectors.toList());

        if (!searchResult.isEmpty()) {
            return searchResult;
        } else {
            throw new NoSuchElementException("Couldn't find these medicines");
        }
    }

    public List<Medicine> getMedicineByProducer(String producer) throws NoSuchElementException {
        List<Medicine> searchResult = medicineStorage.stream()
                .filter(medicine -> medicine.producer.equals(producer))
                .collect(Collectors.toList());

        if (!searchResult.isEmpty()) {
            return searchResult;
        } else {
            throw new NoSuchElementException("Couldn't find these medicines");
        }
    }

    public Medicine getMedicine(String name, int price, String producer) throws NoSuchElementException {
        Optional<Medicine> optionalMedicine = medicineStorage.stream()
                .filter(medicine -> medicine.name.equals(name)
                        && medicine.price == price
                        && medicine.producer.equals(producer))
                .findFirst();

        if (optionalMedicine.isPresent()) {
            return optionalMedicine.get();
        } else {
            throw new NoSuchElementException("Couldn't find these medicines");
        }
    }

}
