package christmas.model.domain;

import christmas.system.Badge;

public record Result(int totalAmount, int totalBenefitAmount, int totalPurchaseAmount,
                     Benefit benefit, Giveaway giveaway, Badge badge) {

}
