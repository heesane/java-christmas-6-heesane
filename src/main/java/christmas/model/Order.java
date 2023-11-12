package christmas.model;

import java.util.HashMap;

import static christmas.view.constant.ViewMessages.AMOUNT;
import static christmas.view.constant.ViewMessages.WHITESPACE;

public class Order {
    private final HashMap<String,Integer> order;
    public Order(HashMap<String,Integer> order){
        this.order = order;
    }
    public String getMenuName(){
        return order.keySet().stream().findFirst().get();
    }
    public Integer getQuantity(){
        return order.values().stream().findFirst().get();
    }
    @Override
    public String toString(){
        return getMenuName()+
                WHITESPACE.getMessage()+
                getQuantity()+
                AMOUNT.getMessage();
    }
}
