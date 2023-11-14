package christmas;

import christmas.controller.BenefitController;
import christmas.controller.OrderController;
import christmas.controller.ReservationController;
import christmas.controller.ResultController;
import christmas.model.service.BenefitService;
import christmas.model.service.OrderService;
import christmas.model.service.ReservationService;
import christmas.model.service.ResultService;
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

    private final BenefitService benefitService = new BenefitService(orderService, reservationService);

    private final ResultService resultService = new ResultService(orderService, benefitService);

    private final BenefitController benefitController = new BenefitController(benefitService);

    private final ResultController resultController = new ResultController(resultService);

    public void run() {
        outputView.printWelcomeMessage();

        promotionUtil.tryUntilValidate(reservationController::reserve);
        promotionUtil.tryUntilValidate(orderController::order);

        benefitController.calculateBenefit();
        resultController.createResult();

        outputView.printBenefitPreview(reservationService.getReservation(), orderService.getOrder());
    }
}
