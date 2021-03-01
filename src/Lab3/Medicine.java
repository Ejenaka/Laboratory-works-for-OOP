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
