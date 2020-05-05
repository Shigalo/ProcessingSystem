package by.bsuir.shabanovich.Supporting;

import java.util.ArrayList;

public class DeliveryData {

    private int precedence;
    private String address;
    private String customer;

    DeliveryData(String address, String customer) {
        this.address = address;
        this.customer = customer;
    }

    public DeliveryData(int precedence, String address, String customer) {
        this.precedence = precedence;
        this.address = address;
        this.customer = customer;
    }

    void setPrecedence(int precedence) {
        this.precedence = precedence;
    }

    ArrayList<String> GetData() {
        ArrayList<String> result = new ArrayList<>();
        result.add(String.valueOf(precedence));
        result.add(address);
        result.add(customer);
        return result;
    }

    static ArrayList<String> GetLabels() {
        ArrayList<String> result = new ArrayList<>();
        result.add("#");
        result.add("Адрес");
        result.add("Покупатель");
        return result;
    }
}
