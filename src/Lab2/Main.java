package Lab2;

import Lab2.ProductCore.*;
import Lab2.StringComparators.*;
import Lab2.UserCore.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Task 46
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        FoodStuff steak = null;
        try {
            steak = new FoodStuff("angus",
                    "meat firm",
                    format.parse("31.01.2021"),
                    format.parse("31.02.2021"),
                    FoodType.MEAT
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(steak.toString());
        steak.overloadingMethod(1);
        steak.overloadingMethod(2,3);

        RadioElectronic phone = null;
        try {
            phone = new RadioElectronic("Iphone XR",
                    "Apple",
                    format.parse("10.10.2018"),
                    RadioElectronicType.PHONE,
                    format.parse("10.10.2023")
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(phone.toString());

        RadioElectronic tv = new RadioElectronic();

        // Task 35
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        LabMethods methods = new LabMethods();
        methods.map(array, (x)->x*2);
        System.out.println(Arrays.toString(array));

        // Task 54
        String[] strings = {"look", "couch", "car", "keyboard", "mouse", "dust"};

        Arrays.sort(strings, new StringLengthComparator());
        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings, new StringThirdCharComparator());
        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings, new StringVowelsComparator());
        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings, new StringVowelsComparator().reversed());
        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings, new StringVowelsComparator().thenComparing(new StringLengthComparator()));
        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings, new StringVowelsComparator().thenComparingInt(s -> s.charAt(0)));
        System.out.println(Arrays.toString(strings));

        // Task 46
        Customer customer = new Customer("Kiborg",
                "kiborg123",
                "kiborg@gmail.com",
                3806678985L,
                3500,
                "Kosmonavtov street"
        );
        System.out.println(customer.toString());

        int num = customer.overloadingMethod(1);
        int sum = customer.overloadingMethod(2, 3);
        System.out.println(num + " " + sum);

        Seller seller = new Seller();

        // Task 33
        Position professor = Position.PROFESSOR;
        methods.printPositionInfo(professor);
        professor.setSalary(15000);
        professor.setVacationDaysCount(20);
        methods.printPositionInfo(professor);
    }
}