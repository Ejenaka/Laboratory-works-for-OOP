package Lab5;

import Lab3.Client;
import Lab3.Doctor;
import Lab3.Medicine;
import Lab3.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO userDb = new UserDAO();
        MedicineDAO medicineDb = new MedicineDAO();

        User client = new Client("Petrov", "ClientPetrov", "pass1");
        User doctor = new Doctor("Ivanov", "DoctorIvanov", "pass2");
//        client = userDb.create(client);
//        doctor = userDb.create(doctor);

        User foundUser = userDb.findById(2);
        //System.out.println(foundUser.getName());

        foundUser.setName("Dmitriy");
        userDb.update(foundUser);

        List<User> userList = userDb.getAll();
        for (User tmp : userList) {
            System.out.println(tmp.getName());
        }

        try {
            userDb.getConnection().close();
            System.out.println(userDb.getConnection().isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Medicine[] medicines = {
                new Medicine("med1", 100, "prod1", false),
                new Medicine("med2", 200, "prod2", false),
                new Medicine("med3", 300, "prod3", true),
                new Medicine("med4", 200, "someProd", true),
                new Medicine("med5", 200, "prod3", false)
        };

//        for (Medicine med : medicines) {
//            medicineDb.create(med);
//        }

        List<Medicine> medicinesFromDb = medicineDb.getAll();
        for (Medicine med : medicinesFromDb) {
            System.out.println(med.getName());
        }

        System.out.println("--------------------------");
        Medicine foundMedicine = medicineDb.findById(52);
        System.out.println(foundMedicine.getName());

        //medicineDb.create(new Medicine("med1", 500, "prod3", false));
        List<Medicine> foundByName = medicineDb.getMedicineByName("med1");
        System.out.println(foundByName.toString());

        List<Medicine> foundByPrice = medicineDb.getMedicineByPrice(200);
        System.out.println(foundByPrice.toString());

        List<Medicine> foundByProducer = medicineDb.getMedicineByProducer("prod3");
        System.out.println(foundByProducer.toString());

        Medicine found = medicineDb.getMedicine("med1", 100, "prod1");
        System.out.println(found.getName() + " " + found.getPrice() + " " + found.getProducer());
    }
}
