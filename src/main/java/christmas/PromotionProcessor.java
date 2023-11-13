package christmas;

import christmas.controller.OrderController;
import christmas.controller.ReservationController;
import christmas.model.service.OrderService;
import christmas.model.service.ReservationService;
import christmas.view.InputView;

public class PromotionProcessor {

    private final InputView inputView = new InputView();

    private final ReservationService reservationService = new ReservationService();
    private final ReservationController reservationController = new ReservationController(reservationService, inputView);

    private final OrderService orderService = new OrderService();

    private final OrderController orderController = new OrderController(orderService, inputView);

    public ReservationController getReservationController() {
        return reservationController;
    }

    public OrderController getOrderController() {
        return orderController;
    }
}
