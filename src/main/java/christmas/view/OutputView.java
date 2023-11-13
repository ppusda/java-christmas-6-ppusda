package christmas.view;

import christmas.system.Badge;
import christmas.system.Message;

public class OutputView {
    public void printWelcomeMessage() {
        printMessage(Message.OUTPUT_WELCOME_MESSAGE.getMessage());
    }

    public void printPreviewMessage(int day) {
        System.out.printf(Message.OUTPUT_PREVIEW.getMessage(), day);
    }

    public void printOrderMenu() {
        System.out.println(Message.OUTPUT_ORDER_MENU);
        // TODO : foreach 이용하여 구현
        System.out.print(Message.OUTPUT_MENU_WITH_AMOUNT); // 음식 n개
    }

    public void printTotalAmount() {
        System.out.println(Message.OUTPUT_TOTAL_AMOUNT.getMessage());
        System.out.printf(Message.OUTPUT_UNIT.getMessage(), "50,000");
    }

    public void printGiveawayMenu() {
        System.out.println(Message.OUTPUT_GIVEAWAY_MENU.getMessage());
        System.out.println(Message.OUTPUT_MENU_WITH_AMOUNT); // 샴페인 n개
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

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

}
