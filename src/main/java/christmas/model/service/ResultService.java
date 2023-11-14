package christmas.model.service;

import christmas.model.domain.Dish;
import christmas.model.domain.Result;

public class ResultService {

    private Result result;

    private final OrderService orderService;
    private final BenefitService benefitService;

    private int totalAmount = 0;
    private Dish benefitDish;

    public ResultService(OrderService orderService, BenefitService benefitService) {
        this.orderService = orderService;
        this.benefitService = benefitService;
    }

    public void setResult() {
        calculateTotalAmount();
        benefitDish = benefitService.checkGiveawayBenefit(totalAmount);

        result = new Result(totalAmount, calculateTotalBenefitAmount(),
                calculateTotalPurchaseAmount(),
                benefitService.getBenefit(), benefitDish);
    }

    public void calculateTotalAmount() {
        for (Dish dish : orderService.getOrder().dishList()) {
            totalAmount += (dish.menu().getPrice() * Integer.parseInt(dish.amount()));
        }
    }

    public int calculateTotalBenefitAmount() {
        return benefitService.getTotalBenefitAmount()
                + benefitService.getGiveawayBenefit(benefitDish);
    }

    public int calculateTotalPurchaseAmount() {
        return totalAmount - calculateTotalBenefitAmount();
    }

    public Result getResult() {
        return result;
    }
}
