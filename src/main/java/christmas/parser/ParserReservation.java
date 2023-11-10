package christmas.parser;

import christmas.exception.reservation.InvalidReservationDateException;
import christmas.model.Reservation;
import christmas.validator.ReservationValidator;
import christmas.view.InputView;

public class ParserReservation {
    private static ReservationValidator validator;
    private InputView input;

    public ParserReservation(InputView input){
        validator = new ReservationValidator();
        this.input = input;
    }
    public Reservation parseReservation(String reservationDay){
        try{
            validator.isValidReservationDay(reservationDay);
        }catch(InvalidReservationDateException e){
            printErrorMessage(e.getMessage());
            return parseReservation(input.inputReservationDay());
        }

        return new Reservation(Integer.parseInt(reservationDay));
    }
    private void printErrorMessage(String ErrorMessage){
        System.out.println(ErrorMessage);
    }
}
