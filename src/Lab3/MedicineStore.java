package Lab3;

import java.util.*;
import java.util.stream.Collectors;

public class MedicineStore implements MedicineGetable{
    private UserSystem userSystem;
    private ArrayList<Medicine> medicineStorage;

    public MedicineStore() {
        userSystem = new UserSystem();
        medicineStorage = new ArrayList<>();
    }

    public MedicineStore(Medicine[] medicineStorage) {
        userSystem = new UserSystem();
        this.medicineStorage = new ArrayList<>(Arrays.asList(medicineStorage));
    }

    public List<Medicine> getMedicineStorage() {
        return medicineStorage;
    }

    public void applyMedicines(Medicine[] medicines) {
        medicineStorage.addAll(List.of(medicines));
    }

    public UserSystem getUserSystem() {
        return userSystem;
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
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
