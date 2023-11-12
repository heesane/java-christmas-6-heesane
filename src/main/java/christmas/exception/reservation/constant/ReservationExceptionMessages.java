package christmas.exception.reservation.constant;

public enum ReservationExceptionMessages {
    INVALID_RESERVATION_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    private final String message;
    private final String PREFIX = "[ERROR] ";
    ReservationExceptionMessages(String message){
        this.message = message;
    }
    public String getMessage(){
        return PREFIX + message;
    }
}
