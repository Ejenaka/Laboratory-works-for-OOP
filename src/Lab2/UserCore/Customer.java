package Lab2.UserCore;

public class Customer extends User {
    private int wallet;
    private String deliveryAddress;

    public Customer(String login, String password, String email, long phoneNumber, int wallet, String deliveryAddress) {
        super(login, password, email, phoneNumber);
        if (wallet < 0) {
            throw new NumberFormatException();
        }
        this.wallet = wallet;
        this.deliveryAddress = deliveryAddress;
        System.out.println("Customer constructor");
    }

    public int overloadingMethod(int num){
        return num;
    }

    public int overloadingMethod(int a, int b) {
        return a + b;
    }

    @Override
    public String toString() {
        return super.toString() + ", Wallet: " + wallet + ", Delivery address: " + deliveryAddress + "}";
    }
}
