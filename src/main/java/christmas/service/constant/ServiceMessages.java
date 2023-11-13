package christmas.service.constant;

public enum ServiceMessages {
    INIT_PRICE(0),
    EVENT_LIMIT(10000),
    CHRISTMAS_INIT_BENEFIT(1000),
    CHRISTMAS_BENEFIT(100),
    WEEK_BENEFIT(2023),
    WEEKEND_BENEFIT(2023),
    SPECIAL_BENEFIT(1000),
    FREE_GIFT_BENEFIT(25000),
    FREE_GIFT_LIMIT(120000);
    private final Integer number;

    ServiceMessages(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return number;
    }
}
