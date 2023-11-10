package christmas.service;

import christmas.model.OrderInfo;
import christmas.model.Reservation;
import christmas.parser.ParserOrderInfo;
import christmas.parser.ParserReservation;

public class ChristmasService {
    private final ParserReservation parserReservation;
    private final ParserOrderInfo parserOrderInfo;
    public ChristmasService(ParserReservation parserReservation, ParserOrderInfo parserOrderInfo){
        this.parserReservation = parserReservation;
        this.parserOrderInfo = parserOrderInfo;
    }
    public Reservation makeReservation(String reservationDay) {
        return parserReservation.parseReservation(reservationDay);
    }

    public OrderInfo makeOrderInfo(String orderList){
        return parserOrderInfo.parserOrderInfo(orderList);
    }
}
