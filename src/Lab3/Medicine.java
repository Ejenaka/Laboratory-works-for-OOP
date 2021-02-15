package Lab3;

public class Medicine {
    private String name;
    private int price;
    private String producer;
    private boolean isRequireDoctor;

    public Medicine(String name, int price, String producer, boolean isRequireDoctor) {
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.isRequireDoctor = isRequireDoctor;
    }
}
