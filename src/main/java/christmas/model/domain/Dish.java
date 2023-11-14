package christmas.model.domain;

import static christmas.system.Exception.ORDER_MENU_ERROR;
import static christmas.system.Validation.ORDER_DISH_AMOUNT_PATTERN;

import christmas.system.Menu;
import christmas.system.Validation;
import java.util.Objects;
import java.util.regex.Pattern;

public record Dish (Menu menu, String amount){

    public Dish(Menu menu, String amount) {
        validateAmountIsNumber(amount);
        validateAmountInRange(amount);

        this.menu = menu;
        this.amount = amount;
    }

    public void validateAmountIsNumber(String amount) {
        if (!Pattern.matches(ORDER_DISH_AMOUNT_PATTERN.getPhrase(), amount)) {
            throw new IllegalArgumentException(ORDER_MENU_ERROR.getErrorMessage());
        }
    }

    public void validateAmountInRange(String amount) {
        if (Integer.parseInt(amount) < Integer.parseInt(
                Validation.ORDER_MENU_MIN_RANGE.getPhrase())) {
            throw new IllegalArgumentException(ORDER_MENU_ERROR.getErrorMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dish dish = (Dish) o;
        return Objects.equals(menu, dish.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu);
    }
}
