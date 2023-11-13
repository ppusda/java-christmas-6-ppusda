package christmas.controller;

import christmas.model.service.OrderService;
import christmas.model.service.ReservationService;
import christmas.view.InputView;

public class OrderController {
    private final OrderService orderService;
    private final InputView inputView;

    public OrderController(OrderService orderService, InputView inputView) {
        this.orderService = orderService;
        this.inputView = inputView;
    }

    public void setOrder() {
        orderService.setOrder(inputView.inputOrderMenu());
    }
}
