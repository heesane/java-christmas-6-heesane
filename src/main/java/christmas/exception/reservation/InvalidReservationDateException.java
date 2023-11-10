package christmas.exception.reservation;

import christmas.exception.reservation.constant.ReservationExceptionMessages;

public class InvalidReservationDateException extends IllegalArgumentException{
    public InvalidReservationDateException(){
        super(ReservationExceptionMessages.INVALID_RESERVATION_DATE.getMessage());
    }
}
