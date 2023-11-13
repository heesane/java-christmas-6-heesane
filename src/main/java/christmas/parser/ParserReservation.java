package christmas.parser;

import christmas.exception.reservation.InvalidReservationDateException;
import christmas.model.Reservation;
import christmas.validator.ReservationValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ParserReservation {
    private static ReservationValidator validator;
    private final InputView input;
    private final OutputView output;

    public ParserReservation() {
        validator = new ReservationValidator();
        this.input = new InputView();
        this.output = new OutputView();
    }

    public Reservation parseReservation(String reservationDay) {
        if (validate(reservationDay)) return parseReservation(input.inputReservationDay());
        return new Reservation(Integer.parseInt(reservationDay));
    }

    private boolean validate(String reservationDay) {
        try {
            validator.isValidReservationDay(reservationDay);
        } catch (InvalidReservationDateException e) {
            output.printExceptionMessage(e);
            return true;
        }
        return false;
    }
}
