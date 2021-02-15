package Lab3;

public class Medicine {
    protected String name;
    protected int price;
    protected String producer;
    protected boolean isRequireDoctor;

    public Medicine(String name, int price, String producer, boolean isRequireDoctor) {
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.isRequireDoctor = isRequireDoctor;
    }
}
