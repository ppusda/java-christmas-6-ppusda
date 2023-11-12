package christmas.system;

public enum Validation {
    RESERVATION_DATE_PATTERN("\\d+"),
    RESERVATION_MIN_DATE_RANGE("1"),
    RESERVATION_MAX_DATE_RANGE("31");

    Validation(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }

    private final String phrase;
}
