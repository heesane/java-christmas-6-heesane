package christmas.model;

public class OrderInfo {
    private final OrderList orderList;
    private final Price price;

    public OrderInfo(OrderList orderList, Price price){
        this.orderList = orderList;
        this.price = price;
    }
    public OrderList getOrderList(){
        return orderList;
    }
    public Price getPrice(){
        return price;
    }
}
