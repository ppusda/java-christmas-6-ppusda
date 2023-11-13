package christmas.system;

public enum Validation {
    RESERVATION_DATE_PATTERN("\\d+"),
    RESERVATION_MIN_DATE_RANGE("1"),
    RESERVATION_MAX_DATE_RANGE("31"),
    ORDER_MENU_MIN_RANGE("1"),
    ORDER_DISH_AMOUNT_PATTERN("\\d+"),
    ORDER_INPUT_PATTERN("^([가-힣]+-\\d+,)*[가-힣]+-\\d+$");


    Validation(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }

    private final String phrase;
}
