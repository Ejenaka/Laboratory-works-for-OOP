package Lab2.ProductCore;

import java.util.Date;

public class Product {
    private String name;
    private String producer;
    private Date productionDate;

    public Product(String name, String producer, Date productionDate) {
        this.name = name;
        this.producer = producer;
        this.productionDate = productionDate;
        System.out.println("Product constructor");
    }

    public Product() {
        System.out.println("Product default constructor");
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Producer: " + producer + ", Production date: " + productionDate.toString();
    }
}
