package Lab3;

import java.util.ArrayList;

public class Client extends User {
    private ArrayList<Medicine> medicineList;

    public Client(String name, String username, String password) {
        super(name, username, password);
        medicineList = new ArrayList<>();
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

    public ArrayList<Medicine> uploadOrder() {
        return medicineList;
    }
}
