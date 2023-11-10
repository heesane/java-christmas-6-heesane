package christmas.exception.order.constant;

public enum OrderExceptionMessages {
    INVALID_ORDER_FORMAT("유효하지 않은 주문입니다. 다시 입력해 주세요.");
    private final String message;
    private final String PREFIX = "[ERROR] ";
    OrderExceptionMessages(String message){
        this.message = message;
    }
    public String getMessage(){
        return PREFIX + message;
    }
}
