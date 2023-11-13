package christmas.system;

public enum Phrase {
    ORDER_INPUT_DELIMITER(","),
    ORDER_DELIMITER("-");

    Phrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }

    private final String phrase;
}
