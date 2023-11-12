package christmas.view.constant;

public enum ViewMessages {
    WELCOME_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    REQUEST_RESERVATION_DATE_MESSAGE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    REQUEST_MENU_AND_AMOUNT_MESSAGE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    EVENT_PREVIEW_MESSAGE("에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_LIST_MESSAGE("<주문 메뉴>"),
    TOTAL_PRICE_MESSAGE("<할인 전 총주문 금액>"),
    FREE_GIFT_LIST_MESSAGE("<증정 메뉴>"),
    EVENT_MESSAGE("<혜택 내역>"),
    DISCOUNT_MESSAGE("<총혜택 금액>"),
    TOTAL_PRICE_AFTER_DISCOUNT_MESSAGE("<할인 후 예상 결제 금액>"),
    BADGE_MESSAGE("<12월 이벤트 배지>");
    private final String message;
    ViewMessages(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
