package Lab5.Model;

import java.util.List;

public class Doctor extends User {
    public Doctor(String name, String username, String password) {
        super(name, username, password);
    }

    public void viewAndAcceptMedicines(List<Medicine> medicines) {
        for (Medicine medicine: medicines) {
            acceptMedicine(medicine);
        }
    }

    private void acceptMedicine(Medicine medicine) { }
}
