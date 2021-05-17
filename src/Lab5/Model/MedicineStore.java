package Lab5.Model;

import Lab5.DAO.MedicineDAO;

import java.util.*;
import java.util.stream.Collectors;

public class MedicineStore implements MedicineGetable {
    private final MedicineDAO medicinesDb = new MedicineDAO();
    private UserSystem userSystem;
    private List<Medicine> medicineStorage;

    public MedicineStore() {
        userSystem = new UserSystem();
        medicineStorage = medicinesDb.getAll();
    }

    public List<Medicine> getMedicineStorage() {
        return medicineStorage;
    }

    public void addMedicine(Medicine medicine) {
        medicinesDb.create(medicine);
        medicinesDb.updateListFromDB(medicineStorage);
    }

    public UserSystem getUserSystem() {
        return userSystem;
    }

    @Override
    public List<Medicine> getMedicineByName(String name) {
        List<Medicine> searchResult = medicineStorage.stream()
                .filter(medicine -> medicine.name.equals(name))
                .collect(Collectors.toList());

        if (!searchResult.isEmpty()) {
            return searchResult;
        } else {
            return new ArrayList<>();
        }

    }

    @Override
    public List<Medicine> getMedicineByPrice(int price)  {
        List<Medicine> searchResult = medicineStorage.stream()
                .filter(medicine -> medicine.price == price)
                .collect(Collectors.toList());

        if (!searchResult.isEmpty()) {
            return searchResult;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Medicine> getMedicineByProducer(String producer) {
        List<Medicine> searchResult = medicineStorage.stream()
                .filter(medicine -> medicine.producer.equals(producer))
                .collect(Collectors.toList());

        if (!searchResult.isEmpty()) {
            return searchResult;
        } else {
            return new ArrayList<>();
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

    public void deleteMedicine(Medicine medicine) {
        Medicine foundMedicine = getMedicine(medicine.name, medicine.price, medicine.producer);
        medicinesDb.delete(foundMedicine.getId());
        medicinesDb.updateListFromDB(medicineStorage);
    }

}
