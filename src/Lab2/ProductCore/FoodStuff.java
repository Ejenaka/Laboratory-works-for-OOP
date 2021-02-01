package Lab2.ProductCore;

import java.util.Date;

public class FoodStuff extends Product {
    private Date expirationDate;
    private FoodType type;

    public FoodStuff(String name, String producer, Date productionDate, Date expirationDate, FoodType type) {
        super(name, producer, productionDate);
        this.expirationDate = expirationDate;
        this.type = type;
        System.out.println("FoodStuff constructor");
    }

    public FoodStuff() {
        System.out.println("FoodStuff default constructor");
    }

    public void overloadingMethod(int num) {
        System.out.println("num: " + num);
    }

    public void overloadingMethod(int a, int b) {
        System.out.println("num 1: " + a + ", num 2: " + b);
    }

    @Override
    public String toString() {
        return super.toString() + ", Expiration date: " + expirationDate.toString() + ", Type: " + type.toString();
    }
}
