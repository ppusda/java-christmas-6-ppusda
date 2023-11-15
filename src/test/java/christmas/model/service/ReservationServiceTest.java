package christmas.model.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReservationServiceTest {

    private ReservationService reservationService = new ReservationService();

    @Test
    @DisplayName("날짜 예약이 정상적으로 이루어진다.")
    void reservationDate() {
        reservationService.reservationDate("3");

        Assertions.assertEquals(reservationService.getReservation().date(), "3");
    }
}