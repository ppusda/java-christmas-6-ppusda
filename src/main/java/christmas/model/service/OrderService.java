package christmas.model.service;

import christmas.model.domain.Order;
import java.util.Arrays;

public class OrderService {


    public Order setInputOrder(String inputOrder) {
        validateIsMatched(inputOrder);
        return new Order(Arrays.stream(inputOrder.split(",")).toList());
    }

    public void validateIsMatched(String inputOrder) {

    }
}
