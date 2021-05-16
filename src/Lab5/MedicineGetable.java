package Lab5;

import java.util.List;

public interface MedicineGetable {
    List<Medicine> getMedicineByName(String name);
    List<Medicine> getMedicineByPrice(int price);
    List<Medicine> getMedicineByProducer(String producer);
    Medicine getMedicine(String name, int price, String producer);
}
