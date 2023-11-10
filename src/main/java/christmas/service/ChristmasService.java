package christmas.service;

import christmas.model.Reservation;
import christmas.parser.ParserReservation;

public class ChristmasService {
    private final ParserReservation parse;
    public ChristmasService(ParserReservation parse){
        this.parse = parse;
    }
    public Reservation makeReservation(String reservationDay) {
        return parse.parseReservation(reservationDay);
    }
}
