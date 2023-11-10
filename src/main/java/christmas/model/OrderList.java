package christmas.model;

import java.util.HashMap;
import java.util.List;

public class OrderList {
    private final List<Order> orderList;

    public OrderList(List<Order> orderList){
        this.orderList = orderList;
    }

    public Integer getListLength(){
        return orderList.size();
    }
    public List<Order> getOrderList(){
        return orderList;
    }
}
