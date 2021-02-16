package Lab3;

import java.util.HashSet;
import java.util.Scanner;

public class Doctor extends User {
    public Doctor(String name, String username, String password) {
        super(name, username, password);
    }

    public void viewMedicine(Medicine medicine) {
        if (medicine.isRequireDoctor) {
            System.out.println("Accept medicine: " + medicine.name + " ?");
            Scanner scanner = new Scanner(System.in);
            boolean flag = scanner.nextBoolean();
            if (!flag) {
                System.out.println(medicine.name + " is not accepted");
            }
        }
    }

    public void viewAndAcceptMedicines(HashSet<Medicine> medicines) {
        for (Medicine medicine: medicines) {
            viewMedicine(medicine);
        }
    }


}
