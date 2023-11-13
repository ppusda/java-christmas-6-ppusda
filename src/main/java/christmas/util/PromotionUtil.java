package christmas.util;

import christmas.view.OutputView;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PromotionUtil {

    private final OutputView outputView;

    public PromotionUtil(OutputView outputView) {
        this.outputView = outputView;
    }

    public void tryUntilValidate(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
