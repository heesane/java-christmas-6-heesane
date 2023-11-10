package christmas.model;

import java.util.HashMap;

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
}
