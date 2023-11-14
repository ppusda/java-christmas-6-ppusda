package christmas;

import christmas.controller.OrderController;
import christmas.controller.ReservationController;
import christmas.model.service.OrderService;
import christmas.model.service.ReservationService;
import christmas.util.PromotionUtil;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PromotionProcessor {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final PromotionUtil promotionUtil = new PromotionUtil(outputView);

    private final ReservationService reservationService = new ReservationService();
    private final ReservationController reservationController = new ReservationController(reservationService, inputView);

    private final OrderService orderService = new OrderService();

    private final OrderController orderController = new OrderController(orderService, inputView);

    public void run() {
        outputView.printWelcomeMessage();

        promotionUtil.tryUntilValidate(reservationController::reserve);
        promotionUtil.tryUntilValidate(orderController::order);

        outputView.printBenefitPreview(reservationService.getReservation(), orderService.getOrder());
    }
}
