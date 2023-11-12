package christmas.validator;

import christmas.exception.reservation.InvalidReservationDateException;

public class ReservationValidator {
    public void isValidReservationDay(String reservationDay) {
        if (!reservationDay.matches("^([1-9]|[12]\\d|3[01])$")){
            throw new InvalidReservationDateException();
        }
    }
}