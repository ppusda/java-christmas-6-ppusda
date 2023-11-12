package christmas;

import christmas.controller.ReservationController;
import christmas.model.service.ReservationService;
import christmas.view.InputView;

public class PromotionProcessor {

    private final InputView inputView = new InputView();

    private final ReservationService reservationService = new ReservationService();
    private final ReservationController reservationController = new ReservationController(reservationService, inputView);

    public ReservationController getReservationController() {
        return reservationController;
    }

}
