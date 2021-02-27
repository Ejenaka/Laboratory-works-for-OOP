package Lab3;

import java.util.ArrayList;
import java.util.List;

public class Client extends User implements MedicineGetable {
    private ArrayList<Medicine> medicineList;

    public Client(String name, String username, String password) {
        super(name, username, password);
        medicineList = new ArrayList<>();
    }

    @Override
    public List<Medicine> getMedicineByName(String name) {
        return medicineStore.getMedicineByName(name);
    }

    @Override
    public List<Medicine> getMedicineByPrice(int price) {
        return medicineStore.getMedicineByPrice(price);
    }

    @Override
    public List<Medicine> getMedicineByProducer(String producer) {
        return medicineStore.getMedicineByProducer(producer);
    }

    @Override
    public Medicine getMedicine(String name, int price, String producer) {
        return medicineStore.getMedicine(name, price, producer);
    }

    public void orderMedicine(Medicine medicine) throws Exception {
        if (super.isAuthorized) {
            medicineList.add(medicine);
        } else {
            throw new Exception("User is not authorized");
        }
    }

    public void orderMedicine(List<Medicine> medicines) throws Exception {
        if (super.isAuthorized) {
            medicineList.addAll(medicines);
        } else {
            throw new Exception("User is not authorized");
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
