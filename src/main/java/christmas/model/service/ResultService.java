package christmas.model.service;

import christmas.model.domain.Dish;
import christmas.model.domain.Result;

public class ResultService {

    private Result result;

    private final OrderService orderService;
    private final BenefitService benefitService;

    private int totalAmount = 0;

    public ResultService(OrderService orderService, BenefitService benefitService) {
        this.orderService = orderService;
        this.benefitService = benefitService;
    }

    public void setResult() {
        calculateTotalAmount();
        result = new Result(totalAmount, calculateTotalPurchaseAmount(),
                benefitService.getBenefit());
    }

    public void calculateTotalAmount() {
        for (Dish dish : orderService.getOrder().dishList()) {
            totalAmount += (dish.menu().getPrice() * Integer.parseInt(dish.amount()));
        }
    }

    public int calculateTotalPurchaseAmount() {
        return totalAmount - (benefitService.getTotalBenefitAmount()
                + benefitService.getGiveawayBenefit(totalAmount));
    }

    public Result getResult() {
        return result;
    }
}
