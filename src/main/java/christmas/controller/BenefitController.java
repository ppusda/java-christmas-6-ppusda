package christmas.controller;

import christmas.model.service.BenefitService;

public class BenefitController {
    private final BenefitService benefitService;

    public BenefitController(BenefitService benefitService) {
        this.benefitService = benefitService;
    }

    public void calculateBenefit() {
        benefitService.setBenefit();
    }
}
