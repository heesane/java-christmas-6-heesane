package christmas.parser;

import christmas.exception.order.InvalidOrderFormatException;
import christmas.model.Order;
import christmas.model.OrderList;
import christmas.validator.OrderListValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static christmas.constant.stringConstant.COMMA;
import static christmas.constant.stringConstant.DASH;

public class ParserOrderList {
    private static OrderListValidator validator;
    private InputView input;
    private OutputView output;

    public ParserOrderList() {
        validator = new OrderListValidator();
        this.input = new InputView();
        this.output = new OutputView();
    }

    public OrderList parseOrderList(String orderList) {
        if (validate(orderList)) return parseOrderList(input.inputMenuAndAmount());
        String[] orderSplit = orderList.split(COMMA.getMessage());
        List<Order> orderArrayList = getOrderList(orderSplit);
        return new OrderList(orderArrayList);
    }

    private boolean validate(String orderList) {
        try {
            validator.isValidOrderList(orderList);
            validator.checkOrderAmount(orderList);
            validator.checkOrderMenuInMenu(orderList);
        } catch (InvalidOrderFormatException e) {
            output.printExceptionMessage(e);
            return true;
        }
        return false;
    }

    private List<Order> getOrderList(String[] orderSplit) {
        return IntStream.
                iterate(0, i -> i < orderSplit.length, i -> i + 1).
                mapToObj(i -> parseOrder(orderSplit[i])).
                collect(Collectors.toList());
    }

    private Order parseOrder(String order) {
        String[] orderSplit = order.split(DASH.getMessage());
        HashMap<String, Integer> orderMap = new HashMap<>();
        orderMap.put(orderSplit[0], Integer.parseInt(orderSplit[1]));
        return new Order(orderMap);
    }
}
