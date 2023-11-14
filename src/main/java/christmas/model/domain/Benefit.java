package christmas.model.domain;

public record Benefit(int christmasDiscount, int weekdayDiscount, int weekendDiscount,
                      int specialDiscount) {

    public Benefit(int christmasDiscount, int weekdayDiscount, int weekendDiscount,
            int specialDiscount) {
        this.christmasDiscount = christmasDiscount;
        this.weekdayDiscount = weekdayDiscount;
        this.weekendDiscount = weekendDiscount;
        this.specialDiscount = specialDiscount;
    }
}
