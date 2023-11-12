package christmas.model;

import java.util.List;

public record OrderList(List<Order> orderList) {

    public Integer getListLength() {
        return orderList.size();
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Order order : orderList){
            sb.append(order.toString()).append("\n");
        }
        return sb.toString();
    }
}
