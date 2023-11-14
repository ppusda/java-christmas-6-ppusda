package christmas.view;

import static christmas.system.Message.OUTPUT_LINE_BREAK;

import christmas.model.domain.Dish;
import christmas.model.domain.Order;
import christmas.model.domain.Reservation;
import christmas.system.Badge;
import christmas.system.Message;

public class OutputView {

    public void printWelcomeMessage() {
        printMessage(Message.OUTPUT_WELCOME_MESSAGE.getMessage());
    }

    public void printBenefitPreview(Reservation reservation, Order order) {
        printFormatMessage(Message.OUTPUT_PREVIEW.getMessage(), reservation.date());
        printOrderMenu(order);
    }

    public void printOrderMenu(Order order) {
        printCategoryMessage(Message.OUTPUT_ORDER_MENU.getMessage());
        for (Dish dish : order.dishList()) {
            printMenuMessage(Message.OUTPUT_MENU_WITH_AMOUNT.getMessage(),
                    dish.menu().getName(), dish.amount());
        }
    }

    public void printTotalAmount() {
        printMessage(Message.OUTPUT_TOTAL_AMOUNT.getMessage());
        printFormatMessage(Message.OUTPUT_UNIT.getMessage(), "50,000");
    }

    public void printGiveawayMenu() {
        printMessage(Message.OUTPUT_GIVEAWAY_MENU.getMessage());
        printFormatMessage(Message.OUTPUT_MENU_WITH_AMOUNT.getMessage(),
                ""); // 샴페인 n개
    }

    public void printBenefitList() {
        System.out.println(Message.OUTPUT_BENEFIT_LIST);
        // TODO : 혜택내역을 Map 혹은 객체로 받아와 출력
    }

    public void printTotalBenefitAmount() {
        System.out.println(Message.OUTPUT_TOTAL_BENEFIT);
        System.out.println(Message.OUTPUT_BENEFIT_UNIT);
    }

    public void printTotalPurchaseAmount() {
        System.out.println(Message.OUTPUT_TOTAL_PURCHASE_AMOUNT);
        System.out.println(Message.OUTPUT_UNIT);
    }

    public void printEventBadge() {
        System.out.println(Message.OUTPUT_EVENT_BADGE);
        System.out.println(Badge.SANTA.getName()); // 로직 구현 필요
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printCategoryMessage(String message) {
        System.out.println(OUTPUT_LINE_BREAK.getMessage() + message);
    }

    public void printFormatMessage(String message, String format) {
        System.out.printf(message + OUTPUT_LINE_BREAK.getMessage(), format);
    }

    public void printMenuMessage(String message, String name, String amount) {
        System.out.printf(message + OUTPUT_LINE_BREAK.getMessage(), name, amount);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

}
