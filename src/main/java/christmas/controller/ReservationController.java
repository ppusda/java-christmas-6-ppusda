package christmas.controller;

import christmas.model.service.ReservationService;
import christmas.view.InputView;

public class ReservationController {

    private final ReservationService reservationService;
    private final InputView inputView;

    public ReservationController(ReservationService reservationService, InputView inputView) {
        this.reservationService = reservationService;
        this.inputView = inputView;
    }

    public void setReservation() {
        reservationService.reservationDate(inputView.inputDateReservation());
    }

}
