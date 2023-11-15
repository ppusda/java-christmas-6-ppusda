package christmas.model.service;

import static org.junit.jupiter.api.Assertions.*;

import christmas.system.Badge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultServiceTest {

    private OrderService orderService = new OrderService();
    private ReservationService reservationService = new ReservationService();

    private BenefitService benefitService = new BenefitService(orderService, reservationService);

    private ResultService resultService = new ResultService(orderService, benefitService);

    @BeforeEach
    void beforeWork() {
        reservationService.reservationDate("3");
        orderService.setOrder("해산물파스타-2,레드와인-1,초코케이크-1");
        benefitService.setBenefit();
    }

    @Test
    @DisplayName("결과가 올바르게 설정된다.")
    void setResult() {
        resultService.setResult();
        assertEquals(145000, resultService.getResult().totalAmount());
        assertEquals(29223, resultService.getResult().totalBenefitAmount());
        assertEquals(115777, resultService.getResult().totalPurchaseAmount());
        assertEquals(Badge.SANTA, resultService.getResult().badge());
    }

    @Test
    @DisplayName("총 주문 금액을 계산한다.")
    void calculateTotalAmount() {
        resultService.calculateTotalAmount();
        assertEquals(145000, resultService.getTotalAmount());
    }

    @Test
    @DisplayName("총 혜택 금액을 계산한다.")
    void calculateTotalBenefitAmount() {
        resultService.setResult();
        assertEquals(29223, resultService.calculateTotalBenefitAmount());
    }

    @Test
    @DisplayName("총 결제 금액을 계산한다.")
    void calculateTotalPurchaseAmount() {
        resultService.setResult();
        assertEquals(115777, resultService.calculateTotalPurchaseAmount());
    }

    @Test
    @DisplayName("혜택 금액에 따른 배지를 가져온다.")
    void getBadge() {
        resultService.setResult();
        assertEquals(Badge.SANTA, resultService.getBadge());
    }
}