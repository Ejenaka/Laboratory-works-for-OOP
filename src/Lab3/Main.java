package Lab3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Medicine[] medicines = {
                new Medicine("med1", 200, "prod1", false),
                new Medicine("med2", 400, "prod1", false),
                new Medicine("Aspirin", 100, "prod2", false),
                new Medicine("medReq", 400, "prod2", true),
        };
        MedicineStore medicineStore = new MedicineStore(medicines);
        Client petrov = new Client("Petrov", "petrov123", "1234567");
        petrov.signUp(medicineStore,"petrov123", "1234567");
        petrov.authorize("petrov123", "1234567");
        List<Medicine> medicines1 = petrov.getMedicineByPrice(200);
        List<Medicine> medicines2 = petrov.getMedicineByProducer("prod1");
        List<Medicine> medicinesReq = petrov.getMedicineByName("medReq");
        Medicine medicine = petrov.getMedicine("Aspirin", 100, "prod2");
        try {
            petrov.orderMedicine(medicines1);
            petrov.orderMedicine(medicines2);
            petrov.orderMedicine(medicinesReq);
            petrov.orderMedicine(medicine);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        List<Medicine> order = petrov.uploadOrder();
        Doctor doctor = new Doctor("doc", "superdoc", "doc123");
        doctor.viewAndAcceptMedicines(order);
    }
}
