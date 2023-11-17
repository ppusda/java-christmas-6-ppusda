package christmas.system;

import java.util.List;

public enum Calendar {
    BENEFIT_CHRISTMAS_DISCOUNT_DAYS(
            List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
                    "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25")),
    BENEFIT_WEEKDAY_DISCOUNT_DAYS(
            List.of("3", "4", "5", "6", "7", "10", "11", "12", "13", "14", "17", "18", "19",
                    "20", "21", "24", "25", "26", "27", "28", "31")),
    BENEFIT_WEEKEND_DISCOUNT_DAYS(
            List.of("1", "2", "8", "9", "15", "16", "22", "23", "29", "30")),
    BENEFIT_SPECIAL_DISCOUNT_DAYS(List.of("3", "10", "17", "24", "31"));

    Calendar(List<String> days) {
        this.days = days;
    }

    public List<String> getDays() {
        return days;
    }

    private final List<String> days;
}
