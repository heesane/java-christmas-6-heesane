package christmas.Controller;

import christmas.model.*;
import christmas.service.ChristmasService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private final InputView input;
    private final OutputView output;
    private final ChristmasService service;

    public ChristmasController(final InputView input, final OutputView output, final ChristmasService service) {
        this.input = input;
        this.output = output;
        this.service = service;
    }

    public void execute() {
        hello();
        Reservation date = reservation();
        OrderList orderList = orderList();
        Event event = service.makeEvent(date);
        Price price = service.makePrice(orderList, event);
        Bill bill = service.makeBill(orderList, price);
        printResultMessages(date, bill, bill.price());
    }

    private void printResultMessages(Reservation date, Bill bill, Price price) {
        output.printOrderList(date, bill);
        output.printTotalPrice(price);
        output.printFreeGiftList(price);
        output.printEventMessage(bill);
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
