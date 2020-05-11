package by.bsuir.shabanovich.Supporting;

import by.bsuir.shabanovich.Entities.Order;
import by.bsuir.shabanovich.Entities.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DeliveryData {

    private Order order;
    private List<Product> products;

    public DeliveryData(Order order, List<Product> products) {
        this.order = order;
        this.products = products;
    }

    static List<String> GetLabels() {
        List<String> result = new ArrayList<>();
        result.add("Наименование");
        result.add("Артикул");
        result.add("Количество");
        return result;
    }

    String getCustomer() {
        return "ФИО: " + order.getCustomer().getName() +
                "\nАдрес: " + order.getCustomer().getAddress() +
                "\nТип оплаты: " + order.getCustomer().GetPayment() + "\n\n";
    }

    List<String> GetData(int i) {
        List<String> result = new ArrayList<>();
        Product product = products.get(i);
        result.add(product.getNomenclature().getName());
        result.add(product.getNomenclature().getArticle());
        result.add(String.valueOf(product.getOrdered()));
        return result;
    }
}
