package christmas.model.domain;

import static christmas.system.Exception.ORDER_MENU_ERROR;
import static christmas.system.Validation.ORDER_DISH_AMOUNT_PATTERN;

import christmas.system.Menu;
import christmas.system.Validation;
import java.util.regex.Pattern;

public record Dish(String name, String amount) {

    public Dish(String name, String amount) {
        validateAmountIsNumber(amount);
        validateDishInMenu(name);
        validateAmountInRange(amount);

        this.name = name;
        this.amount = amount;
    }

    private void validateDishInMenu(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(name)) {
                return;
            }
        }

        throw new IllegalArgumentException(ORDER_MENU_ERROR.getErrorMessage());
    }

    private void validateAmountIsNumber(String name) {
        if (!Pattern.matches(ORDER_DISH_AMOUNT_PATTERN.getPhrase(), name)) {
            throw new IllegalArgumentException(ORDER_MENU_ERROR.getErrorMessage());
        }
    }

    private void validateAmountInRange(String amount) {
        if (Integer.parseInt(amount) < Integer.parseInt(
                Validation.ORDER_MENU_MIN_RANGE.getPhrase())) {
            throw new IllegalArgumentException(ORDER_MENU_ERROR.getErrorMessage());
        }
    }
}
