package christmas.view;

import static christmas.system.Message.OUTPUT_LINE_BREAK;

import christmas.model.domain.Benefit;
import christmas.model.domain.Dish;
import christmas.model.domain.Order;
import christmas.model.domain.Reservation;
import christmas.model.domain.Result;
import christmas.system.Badge;
import christmas.system.Message;
import christmas.system.Phrase;
import java.text.DecimalFormat;

public class OutputView {

    public void printWelcomeMessage() {
        printMessage(Message.OUTPUT_WELCOME_MESSAGE.getMessage());
    }

    public void printBenefitPreview(Reservation reservation, Order order, Result result) {
        printFormatMessage(Message.OUTPUT_PREVIEW.getMessage(), reservation.date());
        printOrderMenu(order);
        printTotalAmount(result.totalAmount());

        printGiveawayMenu(result);
        printBenefitList(result);

        printTotalBenefitAmount(result.totalBenefitAmount());
        printTotalPurchaseAmount(result.totalPurchaseAmount());
    }

    public void printOrderMenu(Order order) {
        printCategoryMessage(Message.OUTPUT_ORDER_MENU.getMessage());
        for (Dish dish : order.dishList()) {
            printMenuMessage(Message.OUTPUT_MENU_WITH_AMOUNT.getMessage(),
                    dish.menu().getName(), dish.amount());
        }
    }

    public void printTotalAmount(int totalAmount) {
        printCategoryMessage(Message.OUTPUT_TOTAL_AMOUNT.getMessage());
        printFormatMessage(Message.OUTPUT_UNIT.getMessage(), formatAmount(totalAmount));
    }

    public void printGiveawayMenu(Result result) {
        printCategoryMessage(Message.OUTPUT_GIVEAWAY_MENU.getMessage());
        printMenuMessage(Message.OUTPUT_MENU_WITH_AMOUNT.getMessage(),
                result.benefitDish().menu().getName(), result.benefitDish().amount()); // 샴페인 n개
    }

    public void printBenefitList(Result result) {
        printCategoryMessage(Message.OUTPUT_BENEFIT_LIST.getMessage());
        printChristmasDiscount(result.benefit().christmasDiscount());
        printWeekdayDiscount(result.benefit().weekdayDiscount());
        printWeekendDiscount(result.benefit().weekendDiscount());
        printSpecialDiscount(result.benefit().specialDiscount());
        printGiveawayDiscount(result.benefitDish());
    }

    public void printChristmasDiscount(int christmasDiscount) {
        if (christmasDiscount != 0) {
            printDiscountMessage(Message.OUTPUT_BENEFIT_CHRISTMAS_DISCOUNT.getMessage(),
                    String.valueOf(christmasDiscount));
        }
    }

    public void printWeekdayDiscount(int weekdayDiscount) {
        if (weekdayDiscount != 0) {
            printDiscountMessage(Message.OUTPUT_BENEFIT_WEEKDAY_DISCOUNT.getMessage(),
                    String.valueOf(weekdayDiscount));
        }
    }

    public void printWeekendDiscount(int weekendDiscount) {
        if (weekendDiscount != 0) {
            printDiscountMessage(Message.OUTPUT_BENEFIT_WEEKEND_DISCOUNT.getMessage(),
                    String.valueOf(weekendDiscount));
        }
    }

    public void printSpecialDiscount(int specialDiscount) {
        if (specialDiscount != 0) {
            printDiscountMessage(Message.OUTPUT_BENEFIT_SPECIAL_DISCOUNT.getMessage(),
                    String.valueOf(specialDiscount));
        }
    }

    public void printGiveawayDiscount(Dish dish) {
        if (Integer.parseInt(dish.amount()) != 0) {
            printDiscountMessage(Message.OUTPUT_BENEFIT_GIVEAWAY_EVENT.getMessage(),
                    String.valueOf(dish.menu().getPrice()));
        }
    }

    public void printTotalBenefitAmount(int totalBenefitAmount) {
        printCategoryMessage(Message.OUTPUT_TOTAL_BENEFIT.getMessage());
        printFormatMessage(Message.OUTPUT_BENEFIT_UNIT.getMessage(),
                String.valueOf(totalBenefitAmount));
    }

    public void printTotalPurchaseAmount(int totalPurchaseAmount) {
        printCategoryMessage(Message.OUTPUT_TOTAL_PURCHASE_AMOUNT.getMessage());
        printFormatMessage(Message.OUTPUT_UNIT.getMessage(),
                String.valueOf(totalPurchaseAmount));
    }

    public void printEventBadge() {
        printCategoryMessage(Message.OUTPUT_EVENT_BADGE.getMessage());
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

    public void printDiscountMessage(String discountMessage, String format) {
        System.out.print(discountMessage);
        printFormatMessage(Message.OUTPUT_BENEFIT_UNIT.getMessage(), format);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public String formatAmount(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat(Phrase.AMOUNT_FORMAT.getPhrase());
        return decimalFormat.format(amount);
    }

}
