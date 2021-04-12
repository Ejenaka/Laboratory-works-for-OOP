package Lab5;

import Lab3.Client;
import Lab3.Doctor;
import Lab3.User;

public class Main {
    public static void main(String[] args) {
        UserDAO userDb = new UserDAO();
        MedicineDAO medicineDb = new MedicineDAO();

        User client = new Client("Petrov", "ClientPetrov", "pass1");
        User doctor = new Doctor("Ivanov", "DoctorIvanov", "pass2");
        client = userDb.create(client);
        doctor = userDb.create(doctor);

        System.out.println(doctor.getId());
        System.out.println(client.getId());

    }
}
