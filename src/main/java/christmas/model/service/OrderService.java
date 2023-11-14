package christmas.model.service;

import static christmas.system.Exception.ORDER_MENU_ERROR;

import christmas.model.domain.Dish;
import christmas.model.domain.Order;
import christmas.system.Exception;
import christmas.system.Menu;
import christmas.system.Phrase;
import christmas.system.Validation;

import java.util.Arrays;
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

    public void validateDishInMenu(String name) {
        if (Arrays.stream(Menu.values()).noneMatch(menu -> menu.getName().equals(name))) {
            throw new IllegalArgumentException(ORDER_MENU_ERROR.getErrorMessage());
        }
    }

    public String[] splitInputOrder(String inputOrder) {
        return inputOrder.split(Phrase.ORDER_INPUT_DELIMITER.getPhrase());
    }

    public Dish splitOrder(String orderWithAmount) {
        String[] order = orderWithAmount.split(Phrase.ORDER_DELIMITER.getPhrase());

        validateDishInMenu(order[0]);
        return new Dish(getMenu(order[0]), order[1]);
    }
    public Menu getMenu(String name) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getName().equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Order getOrder() {
        return order;
    }
}
