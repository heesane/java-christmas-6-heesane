package christmas.constant;

public enum EventConstant {
    CHRISTMAS_D_DAY_MESSAGE("크리스마스 디데이 할인: -"),
    WEEKDAY_DISCOUNT_MESSAGE("평일 할인: -"),
    WEEKEND_DISCOUNT_MESSAGE("주말 할인: -"),
    SPECIAL_DISCOUNT_MESSAGE("특별 할인: -"),
    FREE_GIFT_MESSAGE("증정 이벤트: -"),
    PRICE("원\n"),
    CHAMPAGNE("샴페인 1개");

    private final String message;
    EventConstant(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
