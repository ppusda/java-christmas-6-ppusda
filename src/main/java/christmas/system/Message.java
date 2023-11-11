package christmas.system;

public enum Message {
    OUTPUT_WELCOME_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    INPUT_SCHEDULE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    INPUT_ORDER_MENU("주문하실 메뉴를 개수와 함께 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    OUTPUT_PREVIEW("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    OUTPUT_ORDER_MENU("<주문 메뉴>"),
    OUTPUT_TOTAL_AMOUNT("<할인 전 총 주문 금액>"),
    OUTPUT_GIVEAWAY_MENU("<증정 메뉴>"),
    OUTPUT_MENU_WITH_AMOUNT("%s %d개"),
    OUTPUT_BENEFIT_LIST("<혜택 내역>"),
    OUTPUT_BENEFIT_CHRISTMAS_DISCOUNT("크리스마스 디데이 할인: "),
    OUTPUT_BENEFIT_WEEKDAY_DISCOUNT("평일 할인: "),
    OUTPUT_BENEFIT_WEEKEND_DISCOUNT("주말 할인: "),
    OUTPUT_BENEFIT_SPECIAL_DISCOUNT("특별 할인: "),
    OUTPUT_BENEFIT_GIVEAWAY_EVENT("증정 이벤트: "),
    OUTPUT_TOTAL_BENEFIT("<총 혜택 금액>"),
    OUTPUT_BENEFIT_UNIT("-%s원"),
    OUTPUT_TOTAL_PURCHASE_AMOUNT("<할인 후 예상 결제 금액>"),
    OUTPUT_UNIT("%s원"),
    OUTPUT_EVENT_BADGE("<12월 이벤트 배지>");

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private final String message;
}
