package christmas.model.domain;

import christmas.system.Exception;
import java.util.HashSet;
import java.util.List;

public record Order(List<Dish> dishList) {

    public Order {
        validateDuplicate(dishList);
    }

    public void validateDuplicate(List<Dish> dishList) {
        if (new HashSet<>(dishList).size() != dishList.size()) {
            throw new IllegalArgumentException(Exception.ORDER_MENU_ERROR.getErrorMessage());
        }
    }

    @Override
    public List<Dish> dishList() {
        return dishList;
    }
}
