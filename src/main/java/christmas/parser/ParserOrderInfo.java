package christmas.parser;

import christmas.model.Order;
import christmas.model.OrderInfo;
import christmas.model.OrderList;
import christmas.model.Price;
import christmas.validator.OrderListValidator;

import java.util.HashMap;
import java.util.List;

public class ParserOrderInfo {
    private static OrderListValidator validator;
    public ParserOrderInfo(){
        validator = new OrderListValidator();
    }
    public OrderInfo parserOrderInfo(String orderList){
        validator.isValidOrderList(orderList);
        validator.checkOrderAmount(orderList);
        validator.checkOrderMenuInMenu(orderList);

        return null;
    }
    public Order parserOrder(String order){
        String[] orderSplit = order.split("-");
        HashMap<String,Integer> orderMap = new HashMap<>();
        orderMap.put(orderSplit[0],Integer.parseInt(orderSplit[1]));
        return new Order(orderMap);
    }

    public OrderList parseOrderList(List<Order> orderList){
        return new OrderList(orderList);
    }
    public Price parsePrice(OrderList orderList){
        Price initPrice = new Price();
        for(Order order : orderList.getOrderList()){
            order.getMenuName()
            initPrice.plusTotalPrice(order);
        }
        return new Price();
    }
}
