package christmas.model.domain;

import static christmas.system.Validation.RESERVATION_DATE_PATTERN;

import christmas.system.Exception;
import christmas.system.Validation;
import java.util.regex.Pattern;

public record Reservation(String date) {

    public Reservation {
        validateIsNumber(date);
        validateIsInRange(date);
    }

    public void validateIsNumber(String date) {
        if (!Pattern.matches(RESERVATION_DATE_PATTERN.getPhrase(), date)) {
            throw new IllegalArgumentException(Exception.RESERVATION_INPUT_ERROR.getErrorMessage());
        }
    }

    public void validateIsInRange(String date) {
        int parsedDate = Integer.parseInt(date);
        if (parsedDate < Integer.parseInt(Validation.RESERVATION_MIN_DATE_RANGE.getPhrase())
                || parsedDate > Integer.parseInt(
                Validation.RESERVATION_MAX_DATE_RANGE.getPhrase())) {
            throw new IllegalArgumentException(Exception.RESERVATION_INPUT_ERROR.getErrorMessage());
        }
    }

    @Override
    public String date() {
        return date;
    }
}
