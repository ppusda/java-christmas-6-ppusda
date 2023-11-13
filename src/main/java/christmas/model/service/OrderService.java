package christmas.model.service;

import christmas.model.domain.Dish;
import christmas.model.domain.Order;
import christmas.system.Exception;
import christmas.system.Phrase;
import christmas.system.Validation;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class OrderService {

    private List<Dish> dishList;

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setOrder(String inputOrder) {
        validateIsMatched(inputOrder);
        dishList = Arrays.stream(splitInputOrder(inputOrder))
                .map(this::splitOrder)
                .toList();
    }

    public void validateIsMatched(String inputOrder) {
        if (!Pattern.matches(Validation.ORDER_INPUT_PATTERN.getPhrase(), inputOrder)) {
            throw new IllegalArgumentException(Exception.ORDER_MENU_ERROR.getErrorMessage());
        }
    }

    public String[] splitInputOrder(String inputOrder) {
        return inputOrder.split(Phrase.ORDER_INPUT_DELIMITER.getPhrase());
    }

    public Dish splitOrder(String order) {
        String[] dish = order.split(Phrase.ORDER_DELIMITER.getPhrase());
        return new Dish(dish[0], dish[1]);
    }
}
