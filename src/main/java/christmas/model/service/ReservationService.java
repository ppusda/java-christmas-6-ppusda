package christmas.model.service;

import christmas.model.domain.Reservation;

public class ReservationService {

    private Reservation reservation;

    public void reservationDate(String date) {
        reservation = new Reservation(date);
    }

    public Reservation getReservation() {
        return reservation;
    }
}
