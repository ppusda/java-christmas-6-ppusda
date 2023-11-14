package christmas.model.service;

import christmas.model.domain.Benefit;
import christmas.model.domain.Dish;
import christmas.system.Calendar;
import christmas.system.Constant;
import christmas.system.Menu;
import christmas.system.Validation;
import java.util.List;

public class BenefitService {

    private Benefit benefit;
    private final OrderService orderService;
    private final ReservationService reservationService;
    private int totalBenefitAmount = 0;

    public BenefitService(OrderService orderService, ReservationService reservationService) {
        this.orderService = orderService;
        this.reservationService = reservationService;
    }

    public void setBenefit() {
        benefit = new Benefit(
                checkChristmasBenefit(),
                checkWeekdayBenefit(),
                checkWeekendBenefit(),
                checkSpecialBenefit());

        setTotalBenefitAmount();
    }

    public int checkChristmasBenefit() {
        if (checkCorrespondInBenefit(Calendar.BENEFIT_CHRISTMAS_DISCOUNT_DAYS.getDays())) {
            return Constant.CHRISTMAS_DISCOUNT_BASIC_AMOUNT.getConstant() + (
                    Constant.CHRISTMAS_DISCOUNT_INCREASE_AMOUNT.getConstant() * (
                            Integer.parseInt(reservationService.getReservation().date())
                                    - Constant.CHRISTMAS_DISCOUNT_CALCULATE_NUMBER.getConstant()));
        }
        return 0;
    }

    public int checkWeekdayBenefit() {
        int dessertCount = 0;
        if (checkCorrespondInBenefit(Calendar.BENEFIT_WEEKDAY_DISCOUNT_DAYS.getDays())) {
            dessertCount = (int) orderService.getOrder().dishList().stream()
                    .filter(dish -> dish.menu().getType()
                            .equals(Validation.ORDER_MENU_TYPE_DESSERT.getPhrase())).count();
        }

        return Constant.DAY_DISCOUNT_AMOUNT.getConstant() * dessertCount;
    }

    public int checkWeekendBenefit() {
        int mainCount = 0;
        if (checkCorrespondInBenefit(Calendar.BENEFIT_WEEKEND_DISCOUNT_DAYS.getDays())) {
            mainCount = (int) orderService.getOrder().dishList().stream()
                    .filter(dish -> dish.menu().getType()
                            .equals(Validation.ORDER_MENU_TYPE_MAIN.getPhrase())).count();
        }

        return Constant.DAY_DISCOUNT_AMOUNT.getConstant() * mainCount;
    }

    public int checkSpecialBenefit() {
        if (checkCorrespondInBenefit(Calendar.BENEFIT_SPECIAL_DISCOUNT_DAYS.getDays())) {
            return Constant.SPECIAL_DISCOUNT_AMOUNT.getConstant();
        }

        return 0;
    }

    public boolean checkCorrespondInBenefit(List<String> dayList) {
        return dayList.stream()
                .anyMatch(day -> day.equals(reservationService.getReservation().date()));
    }

    public Dish checkGiveawayBenefit(int totalAmount) {
        if (totalAmount >= Constant.GIVEAWAY_AMOUNT_CONDITION.getConstant()) {
            return new Dish(Menu.CHAMPAGNE, "1");
        }
        return new Dish(Menu.CHAMPAGNE, "0");
    }

    public int getGiveawayBenefit(Dish giveawayDish) {
        if (Integer.parseInt(giveawayDish.amount()) > 0) {
            return giveawayDish.menu().getPrice();
        }

        return 0;
    }

    public void setTotalBenefitAmount() {
        addDateDiscount(benefit.christmasDiscount());
        addDateDiscount(benefit.weekdayDiscount());
        addDateDiscount(benefit.weekendDiscount());
        addDateDiscount(benefit.specialDiscount());
    }

    public int getTotalBenefitAmount() {
        return totalBenefitAmount;
    }

    public void addDateDiscount(int discount) {
        if (discount != 0) {
            totalBenefitAmount += discount;
        }
    }

    public Benefit getBenefit() {
        return benefit;
    }

}
