package Lab5;

import Lab5.Model.*;
import Lab5.DAO.MedicineDAO;
import Lab5.DAO.UserDAO;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MedicineStore store = new MedicineStore();

        User client = new Client("Petrov", "ClientPetrov", "pass1");
        User doctor = new Doctor("Ivanov", "DoctorIvanov", "pass2");

        client.signUp(store, client.getUsername(), client.getPassword());
        doctor.signUp(store, doctor.getUsername(), doctor.getPassword());

        Client test = new Client("test", "test", "test");
        test.signUp(store, "test", "test");

        List<User> userList = store.getUserSystem().getUsers();
        for (User tmp : userList) {
            System.out.println(tmp.getName());
        }

        Medicine[] medicines = {
                new Medicine("med1", 100, "prod1", false),
                new Medicine("med2", 200, "prod2", false),
                new Medicine("med3", 300, "prod3", true),
                new Medicine("med4", 200, "someProd", true),
                new Medicine("med5", 200, "prod3", false)
        };

        for (Medicine med : medicines) {
            store.addMedicine(med);
        }

        List<Medicine> medicinesFromDb = store.getMedicineStorage();
        for (Medicine med : medicinesFromDb) {
            System.out.println(med.getName());
        }

        System.out.println("--------------------------");

        store.addMedicine(new Medicine("med1", 500, "prod3", false));
        List<Medicine> foundByName = store.getMedicineByName("med1");
        System.out.println(foundByName.toString());

        List<Medicine> foundByPrice = store.getMedicineByPrice(200);
        System.out.println(foundByPrice.toString());

        List<Medicine> foundByProducer = store.getMedicineByProducer("prod3");
        System.out.println(foundByProducer.toString());

        Medicine found = store.getMedicine("med1", 100, "prod1");
        System.out.println(found.getName() + " " + found.getPrice() + " " + found.getProducer());
    }
}
