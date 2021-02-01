package Lab2.ProductCore;

import java.util.Date;

public class RadioElectronic extends Product {
    private RadioElectronicType type;
    private Date warrantyPeriod;

    public RadioElectronic(String name, String producer, Date productionDate, RadioElectronicType type, Date warrantyPeriod) {
        super(name, producer, productionDate);
        this.type = type;
        this.warrantyPeriod = warrantyPeriod;
        System.out.println("RadioElectronic constructor");
    }

    public RadioElectronic() {
        System.out.println("RadioElectronic default constructor");
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: " + type.toString() + ", Warranty period: " + warrantyPeriod.toString();
    }
}
