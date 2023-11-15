package christmas.model.service;

import static org.junit.jupiter.api.Assertions.*;

import christmas.model.domain.Giveaway;
import christmas.system.Calendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitServiceTest {

    private OrderService orderService = new OrderService();
    private ReservationService reservationService = new ReservationService();
    private BenefitService benefitService = new BenefitService(orderService, reservationService);

    @BeforeEach
    void beforeWork() {
        reservationService.reservationDate("3");
        orderService.setOrder("해산물파스타-2,레드와인-1,초코케이크-1");
    }

    @Test
    @DisplayName("혜택을 적용한 경우 총 혜택 금액이 설정 되어있어야한다.")
    void setBenefit() {
        benefitService.setBenefit();
        assertEquals(4223, benefitService.getTotalBenefitAmount());
    }

    @Test
    @DisplayName("크리스마스 할인 금액을 구한다.")
    void checkChristmasBenefit() {
        assertEquals(1200, benefitService.checkChristmasBenefit());
    }

    @Test
    @DisplayName("평일 할인 금액을 구한다.")
    void checkWeekdayBenefit() {
        assertEquals(2023, benefitService.checkWeekdayBenefit());
    }

    @Test
    @DisplayName("주말 할인 금액을 구한다.")
    void checkWeekendBenefit() {
        assertEquals(0, benefitService.checkWeekendBenefit());
    }

    @Test
    @DisplayName("특별 할인 금액을 구한다.")
    void checkSpecialBenefit() {
        assertEquals(1000, benefitService.checkSpecialBenefit());
    }

    @Test
    @DisplayName("3일이 크리스마스 혜택에 포함되는지 검사한다.")
    void checkCorrespondInBenefit() {
        assertTrue(benefitService.checkCorrespondInBenefit(
                Calendar.BENEFIT_CHRISTMAS_DISCOUNT_DAYS.getDays()));
    }

    @Test
    @DisplayName("혜택 적용 전 총 금액이 120,000원이 넘어가면 샴페인을 증정한다.")
    void checkGiveawayBenefit() {
        Giveaway giveaway = benefitService.checkGiveawayBenefit(120000);
        assertEquals(giveaway.amount(), 1);
    }

    @Test
    @DisplayName("증정용 샴페인의 가격을 반환한다.")
    void getGiveawayBenefit() {
        Giveaway giveaway = benefitService.checkGiveawayBenefit(120000);
        assertEquals(25000, benefitService.getGiveawayBenefit(giveaway));
    }

}