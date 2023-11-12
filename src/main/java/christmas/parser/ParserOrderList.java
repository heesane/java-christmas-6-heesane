package christmas.parser;

import christmas.exception.order.InvalidOrderFormatException;
import christmas.model.*;
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

    public ParserOrderList(InputView input, OutputView output){
        validator = new OrderListValidator();
        this.input = input;
        this.output = output;
    }
    public OrderList parseOrderList(String orderList) {
        try {
            validator.isValidOrderList(orderList);
            validator.checkOrderAmount(orderList);
            validator.checkOrderMenuInMenu(orderList);
        } catch (InvalidOrderFormatException e) {
            output.printExceptionMessage(e);
            return parseOrderList(input.inputMenuAndAmount());
        }
        String[] orderSplit = orderList.split(COMMA.getMessage());
        List<Order> orderArrayList = IntStream.
                iterate(0, i -> i < orderSplit.length, i -> i + 1).
                mapToObj(i -> parseOrder(orderSplit[i])).
                collect(Collectors.toList());
        return new OrderList(orderArrayList);
    }
    private Order parseOrder(String order){
        String[] orderSplit = order.split(DASH.getMessage());
        HashMap<String,Integer> orderMap = new HashMap<>();
        orderMap.put(orderSplit[0],Integer.parseInt(orderSplit[1]));
        return new Order(orderMap);
    }
}
