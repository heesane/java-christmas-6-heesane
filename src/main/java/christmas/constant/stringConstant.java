package christmas.constant;

public enum stringConstant {
    COMMA(","),
    DASH("-"),
    DECEMBER("12"),
    MONTH("월 "),
    DAY("일"),
    EMPTY("없음"),
    PRICE_EMPTY("0원"),
    PRICE("원"),
    AMOUNT("개"),
    WHITESPACE(" ");;
    private final String message;
    stringConstant(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
