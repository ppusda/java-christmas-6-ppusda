package christmas.system;

public enum Constant {
    CHRISTMAS_DISCOUNT_BASIC_AMOUNT(1000),
    CHRISTMAS_DISCOUNT_INCREASE_AMOUNT(100),
    CHRISTMAS_DISCOUNT_CALCULATE_NUMBER(1),
    DAY_DISCOUNT_AMOUNT(2023),
    SPECIAL_DISCOUNT_AMOUNT(1000),
    GIVEAWAY_AMOUNT_CONDITION(120000);

    Constant(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }

    private final int constant;

}
