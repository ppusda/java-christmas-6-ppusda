package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.system.Message;

public class InputView {
    public String inputDateReservation() {
        printMessage(Message.INPUT_SCHEDULE.getMessage());
        return Console.readLine().trim();
    }

    public String inputOrderMenu() {
        printMessage(Message.INPUT_ORDER_MENU.getMessage());
        return Console.readLine().trim();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
