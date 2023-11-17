package christmas.model.service;

import static org.junit.jupiter.api.Assertions.*;

import christmas.model.domain.Dish;
import christmas.model.domain.Order;
import christmas.system.Menu;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    private OrderService orderService = new OrderService();

    @Test
    @DisplayName("형식에 맞게 주문 했을 때, Order 객체로 알맞게 반환한다.")
    void correctOrder() {
        orderService.setOrder("해산물파스타-2,레드와인-1,초코케이크-1");

        Order order = new Order(List.of(
                new Dish(Menu.SEAFOOD_PASTA, "2"),
                new Dish(Menu.RED_WINE, "1"),
                new Dish(Menu.CHOCO_CAKE, "1")));

        assertEquals(orderService.getOrder(), order);
    }

    @Test
    @DisplayName("중복 메뉴를 입력했을 때, 예외가 발생한다.")
    void duplicateOrder() {
        assertThrows(IllegalArgumentException.class, () -> {
            orderService.setOrder("해산물파스타-2,레드와인-1,해산물파스타-1");
        });
    }

    @Test
    @DisplayName("형식에 맞지 않게 주문 했을 때, 예외가 발생한다.")
    void notMatchedPatternOrder() {
        assertThrows(IllegalArgumentException.class, () -> {
            orderService.validateIsMatched("해산물파스타 2개, 레드와인 1개, 초코케이크 1개");
        });
    }

    @Test
    @DisplayName("메뉴에 없는 음식을 주문 한 경우, 예외가 발생한다.")
    void OrderIsNotInMenu() {
        assertThrows(IllegalArgumentException.class, () -> {
            orderService.validateDishInMenu("피자");
        });
    }

    @Test
    @DisplayName("주문 목록을 분리한다.")
    void splitInputOrder() {
        String[] splitOrder = orderService.splitInputOrder("해산물파스타-2,레드와인-1,초코케이크-1");
        String[] splitedOrder = new String[]{"해산물파스타-2", "레드와인-1", "초코케이크-1"};

        assertEquals(splitedOrder[0], splitOrder[0]);
        assertEquals(splitedOrder[1], splitOrder[1]);
        assertEquals(splitedOrder[2], splitOrder[2]);
    }

    @Test
    @DisplayName("분리된 주문을 메뉴와 양으로 나눈다.")
    void splitOrder() {
        Dish dish = orderService.splitOrder("해산물파스타-2");
        Dish orderedDish = new Dish(Menu.SEAFOOD_PASTA, "2");

        assertEquals(orderedDish.menu(), dish.menu());
        assertEquals(orderedDish.amount(), dish.amount());
    }

    @Test
    @DisplayName("메뉴의 이름을 제공하면 메뉴로 반환해준다.")
    void getMenu() {
        assertEquals(Menu.SEAFOOD_PASTA, orderService.getMenu("해산물파스타"));
    }
}