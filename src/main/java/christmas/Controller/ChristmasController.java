package christmas.Controller;

import christmas.model.*;
import christmas.parser.ParserOrderList;
import christmas.parser.ParserReservation;
import christmas.service.ChristmasService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private final InputView input;
    private final OutputView output;
    private final ChristmasService service;
    private final ParserReservation parserReservation;
    private final ParserOrderList parserOrderList;
    public ChristmasController(){
        input = new InputView();
        output = new OutputView();
        parserReservation = new ParserReservation(input,output);
        parserOrderList = new ParserOrderList(input,output);
        service = new ChristmasService(parserReservation, parserOrderList);
    }
    public void execute(){
        output.printWelcome();
        output.printRequestReservationDate();
        String reservationDay = input.inputReservationDay();
        Reservation date = service.makeReservation(reservationDay);
        output.printRequestMenuAndAmount();
        String order = input.inputMenuAndAmount();
        OrderList orderList = service.makeOrderList(order);
        Event event = service.makeEvent(date);
        Price price = service.makePrice(orderList, event);
        OrderInfo orderInfo = service.makeOrderInfo(orderList,price);
        System.out.println(orderInfo.price().toString());
        System.out.println(orderInfo.price().specialBenefits());
        printResultMessages(date,orderInfo,orderInfo.price());
    }
    private void printResultMessages(Reservation date, OrderInfo orderInfo, Price price){
        output.printOrderList(date,orderInfo);
        output.printTotalPrice(price);
        output.printFreeGiftList(price);
        output.printEventMessage(orderInfo);
        output.printDiscount(price);
        output.printTotalPriceAfterDiscount(price);
        output.printBadgeMessage(price);
    }
}
