package christmas.Controller;

import christmas.model.OrderInfo;
import christmas.model.Reservation;
import christmas.parser.ParserOrderInfo;
import christmas.parser.ParserReservation;
import christmas.service.ChristmasService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private final InputView input;
    private final OutputView output;
    private final ChristmasService service;
    private final ParserReservation parserReservation;
    private final ParserOrderInfo parserOrderInfo;
    public ChristmasController(){
        input = new InputView();
        output = new OutputView();
        parserReservation = new ParserReservation(input);
        parserOrderInfo = new ParserOrderInfo();
        service = new ChristmasService(parserReservation, parserOrderInfo);
    }
    public void execute(){
        PrintHelloMessages();
        String reservationDay = PrintRequestReservationDate();
        Reservation date = service.makeReservation(reservationDay);
        System.out.println(date.reservationDay());
        String order = PrintRequestOrder();
        OrderInfo orderInfo = service.makeOrderInfo(order);


    }
    private void PrintHelloMessages(){
        output.printWelcome();
    }
    private String PrintRequestReservationDate(){
        output.printRequestReservationDate();
        return input.inputReservationDay();
    }
    private String PrintRequestOrder(){
        output.printRequestMenuAndAmount();
        return input.inputMenuAndAmount();
    }
}
