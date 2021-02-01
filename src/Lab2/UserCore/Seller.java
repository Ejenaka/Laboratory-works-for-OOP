package Lab2.UserCore;

import java.util.Date;

public class Seller extends User {
    private int departmentNumber;
    private Date hiringDate;
    private int bonusSum;

    public Seller(String login, String password, String email, int phoneNumber, int departmentNumber, Date hiringDate, int bonusSum) {
        super(login, password, email, phoneNumber);
        if (departmentNumber < 0 || bonusSum < 0) {
            throw new NumberFormatException();
        }
        this.departmentNumber = departmentNumber;
        this.hiringDate = hiringDate;
        this.bonusSum = bonusSum;
        System.out.println("Seller constructor");
    }

    public Seller() {
        System.out.println("Seller default constructor");
    }

    @Override
    public String toString() {
        return super.toString() + ", Department number: " + departmentNumber + ", Hiring date" + hiringDate.toString() + ", Bonus sum: " + bonusSum + "}";
    }
}
