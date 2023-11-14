package christmas.model.service;

import christmas.model.domain.Dish;
import christmas.model.domain.Order;
import christmas.system.Exception;
import christmas.system.Phrase;
import christmas.system.Validation;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class OrderService {

    private Order order;

    public void setOrder(String inputOrder) {
        validateIsMatched(inputOrder);
        order = new Order(
                Stream.of(splitInputOrder(inputOrder))
                        .map(this::splitOrder)
                        .toList()
        );
    }

    public void validateIsMatched(String inputOrder) {
        if (!Pattern.matches(Validation.ORDER_INPUT_PATTERN.getPhrase(), inputOrder)) {
            throw new IllegalArgumentException(Exception.ORDER_MENU_ERROR.getErrorMessage());
        }
    }

    public String[] splitInputOrder(String inputOrder) {
        return inputOrder.split(Phrase.ORDER_INPUT_DELIMITER.getPhrase());
    }

    public Dish splitOrder(String orderWithAmount) {
        String[] order = orderWithAmount.split(Phrase.ORDER_DELIMITER.getPhrase());
        return new Dish(order[0], order[1]);
    }

    public Order getOrder() {
        return order;
    }
}
