package christmas.Controller;

import christmas.model.*;
import christmas.service.ChristmasService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private final InputView input;
    private final OutputView output;
    private final ChristmasService service;

    public ChristmasController() {
        input = new InputView();
        output = new OutputView();
        service = new ChristmasService();
    }

    public void execute() {
        hello();
        Reservation date = reservation();
        OrderList orderList = orderList();
        Event event = service.makeEvent(date);
        Price price = service.makePrice(orderList, event);
        OrderInfo orderInfo = service.makeOrderInfo(orderList, price);
        printResultMessages(date, orderInfo, orderInfo.price());
    }

    private void printResultMessages(Reservation date, OrderInfo orderInfo, Price price) {
        output.printOrderList(date, orderInfo);
        output.printTotalPrice(price);
        output.printFreeGiftList(price);
        output.printEventMessage(orderInfo);
        output.printDiscount(price);
        output.printTotalPriceAfterDiscount(price);
        output.printBadgeMessage(price);
    }

    private void hello() {
        output.printWelcome();
    }

    private Reservation reservation() {
        output.printRequestReservationDate();
        String reservationDay = input.inputReservationDay();
        return service.makeReservation(reservationDay);
    }

    private OrderList orderList() {
        output.printRequestMenuAndAmount();
        String order = input.inputMenuAndAmount();
        return service.makeOrderList(order);
    }
}
