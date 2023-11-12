package christmas.system;

public enum Exception {
    RESERVATION_INPUT_ERROR("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    Exception(String error) {
        this.errorMessage = error;
    }

    public String getErrorMessage() {
        return "[ERROR] " + errorMessage;
    }

    private final String errorMessage;
}
