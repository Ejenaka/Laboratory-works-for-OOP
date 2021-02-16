package Lab3;

import java.util.HashSet;
import java.util.Set;

public class Client extends User {
    private HashSet<Medicine> medicineList;

    public Client(String name, String username, String password) {
        super(name, username, password);
        medicineList = new HashSet<>();
    }

    public Medicine findMedicineByName(String name) {
        return MedicineStore.getInstance().getMedicineByName(name);
    }

    public Medicine findMedicineByPrice(int price) {
        return MedicineStore.getInstance().getMedicineByPrice(price);
    }

    public Medicine findMedicineByProducer(String producer) {
        return MedicineStore.getInstance().getMedicineByProducer(producer);
    }

    public void orderMedicine(Medicine medicine) {
        if (super.isAuthorized) {
            medicineList.add(medicine);
        }
    }

    public void editOrder(Medicine medicine, EditOrderOption option) {
        switch (option) {
            case ADD:
                medicineList.add(medicine);
                break;
            case REMOVE:
                medicineList.remove(medicine);
                break;
            case CLEAR:
                medicineList.clear();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }

    public HashSet<Medicine> uploadOrder() {
        return medicineList;
    }
}
