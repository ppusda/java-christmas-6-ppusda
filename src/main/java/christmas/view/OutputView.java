package christmas.view;

import static christmas.system.Message.OUTPUT_LINE_BREAK;

import christmas.model.domain.Dish;
import christmas.model.domain.Giveaway;
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
        printEventBadge(result.badge());
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
        if (result.giveaway().amount() != 0) {
            printCategoryMessage(Message.OUTPUT_GIVEAWAY_MENU.getMessage());
            printMenuMessage(Message.OUTPUT_MENU_WITH_AMOUNT.getMessage(),
                    result.giveaway().menu().getName(), String.valueOf(result.giveaway().amount())); // 샴페인 n개
        }
        printNone();
    }

    public void printBenefitList(Result result) {
        printCategoryMessage(Message.OUTPUT_BENEFIT_LIST.getMessage());

        boolean checkPrint = false;
        checkPrint |= printDiscount(result.benefit().christmasDiscount(),
                Message.OUTPUT_BENEFIT_CHRISTMAS_DISCOUNT.getMessage());
        checkPrint |= printDiscount(result.benefit().weekdayDiscount(),
                Message.OUTPUT_BENEFIT_WEEKDAY_DISCOUNT.getMessage());
        checkPrint |= printDiscount(result.benefit().weekendDiscount(),
                Message.OUTPUT_BENEFIT_WEEKEND_DISCOUNT.getMessage());
        checkPrint |= printDiscount(result.benefit().specialDiscount(),
                Message.OUTPUT_BENEFIT_SPECIAL_DISCOUNT.getMessage());
        checkPrint |= printGiveawayDiscount(result.giveaway());

        if (!checkPrint) {
            printNone();
        }
    }

    public boolean printDiscount(int discount, String message) {
        if (discount != 0) {
            printDiscountMessage(message, discount);
            return true;
        }

        return false;
    }

    public boolean printGiveawayDiscount(Giveaway giveaway) {
        if (giveaway.amount() != 0) {
            printDiscountMessage(Message.OUTPUT_BENEFIT_GIVEAWAY_EVENT.getMessage(),
                    giveaway.menu().getPrice());
            return true;
        }

        return false;
    }

    public void printTotalBenefitAmount(int totalBenefitAmount) {
        printCategoryMessage(Message.OUTPUT_TOTAL_BENEFIT.getMessage());
        printFormatMessage(Message.OUTPUT_BENEFIT_UNIT.getMessage(),
                formatAmount(totalBenefitAmount));
    }

    public void printTotalPurchaseAmount(int totalPurchaseAmount) {
        printCategoryMessage(Message.OUTPUT_TOTAL_PURCHASE_AMOUNT.getMessage());
        printFormatMessage(Message.OUTPUT_UNIT.getMessage(),
                formatAmount(totalPurchaseAmount));
    }

    public void printEventBadge(Badge badge) {
        printCategoryMessage(Message.OUTPUT_EVENT_BADGE.getMessage());
        printMessage(badge.getName());
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

    public void printDiscountMessage(String discountMessage, int format) {
        System.out.print(discountMessage);
        printFormatMessage(Message.OUTPUT_BENEFIT_UNIT.getMessage(), formatAmount(format));
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public String formatAmount(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat(Phrase.AMOUNT_FORMAT.getPhrase());
        return decimalFormat.format(amount);
    }

    public void printNone() {
        System.out.println(Message.OUTPUT_NONE.getMessage());
    }

}
