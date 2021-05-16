package Lab5;

public class Medicine {
    private int id = -1;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getProducer() {
        return producer;
    }

    public boolean isRequireDoctor() {
        return isRequireDoctor;
    }

    public void setRequireDoctor(boolean requireDoctor) {
        isRequireDoctor = requireDoctor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Medicine medicine = (Medicine) obj;

        return name.equals(medicine.name)
                && price == medicine.price
                && producer.equals(medicine.producer)
                && isRequireDoctor == medicine.isRequireDoctor;
    }
}
