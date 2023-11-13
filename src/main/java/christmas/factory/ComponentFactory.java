package christmas.factory;

import christmas.Controller.ChristmasController;
import christmas.parser.ParserOrderList;
import christmas.parser.ParserReservation;
import christmas.service.ChristmasService;
import christmas.validator.OrderListValidator;
import christmas.validator.ReservationValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ComponentFactory {
    private static ComponentFactory instance;

    private ComponentFactory() {
    }

    public static ComponentFactory getInstance() {
        if (instance == null) {
            instance = new ComponentFactory();
        }
        return instance;
    }

    public ChristmasController christmasController() {
        return new ChristmasController(inputView(), outputView(), christmasService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private ChristmasService christmasService() {
        return new ChristmasService(parserReservation(), parserOrderList());
    }
    private ParserReservation parserReservation() {
        return new ParserReservation(inputView(), outputView(), reservationValidator());
    }
    private ParserOrderList parserOrderList() {
        return new ParserOrderList(inputView(), outputView(), OrderListValidator());
    }
    private OrderListValidator OrderListValidator() {
        return new OrderListValidator();
    }
    private ReservationValidator reservationValidator() {
        return new ReservationValidator();
    }
}
