package Lab3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Medicine[] medicines = {
                new Medicine("med1", 200, "prod1", false),
                new Medicine("medReq", 400, "prod2", true),
        };
        MedicineStore medicineStore = MedicineStore.getInstance();
        Client petrov = new Client("Petrov", "petrov123", "1234567");
        petrov.signUp("petrov123", "1234567");
        petrov.authorize("petrov123", "1234567");
        Medicine med1 = petrov.findMedicineByPrice(200);
        Medicine med2 = petrov.findMedicineByName("medReq");
        petrov.orderMedicine(med1);
        petrov.orderMedicine(med2);
        ArrayList<Medicine> order = petrov.uploadOrder();
        Doctor doctor = new Doctor("doc", "superdoc", "doc123");
        doctor.viewAndAcceptMedicines(order);
    }
}
