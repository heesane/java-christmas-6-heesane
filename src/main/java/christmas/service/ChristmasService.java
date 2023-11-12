package christmas.service;

import christmas.model.*;
import christmas.parser.ParserOrderList;
import christmas.parser.ParserReservation;

public class ChristmasService {
    private final ParserReservation parserReservation;
    private final ParserOrderList parserOrderList;
    public ChristmasService(){
        this.parserReservation = new ParserReservation();
        this.parserOrderList = new ParserOrderList();
    }
    public Reservation makeReservation(String reservationDay) {
        return parserReservation.parseReservation(reservationDay);
    }
    public OrderList makeOrderList(String orderList){
        return parserOrderList.parseOrderList(orderList);
    }
    public Event makeEvent(Reservation date){
        return new Event(date);
    }
    public Price makePrice(OrderList orderList, Event event){
        Menu menu = new Menu();
        Integer totalPrice = getTotalPrice(orderList, menu);
        if(totalPrice <10000){
            return new Price(totalPrice,0,0,0,0,0);
        }
        return new Price(
                totalPrice,
                getChristmasBenefits(event),
                getWeekBenefits(orderList, event, menu),
                getWeekEndBenefits(orderList, event, menu),
                getSpecialBenefits(event),
                getFreeGiftBenefits(totalPrice));
    }
    private int getTotalPrice(OrderList orderList, Menu menu){
        int totalPrice = 0;
        for(Order order : orderList.orderList()){
            String menuName = order.getMenuName();
            totalPrice += menu.getMenuPrice(menuName) * order.getQuantity();;
        }
        return totalPrice;
    }
    private int getChristmasBenefits(Event event){
        int christmasBenefits = 0;
        if(event.isChristmasDday()){
            christmasBenefits += (event.getDate().reservationDay()-1) * 100 + 1000;
        }
        return christmasBenefits;
    }
    private int getWeekBenefits(OrderList orderList, Event event, Menu menu){
        int weekBenefits = 0;
        if(event.isWeek()){
            for(Order order : orderList.orderList()){
                String menuName = order.getMenuName();
                if(menu.isDessert(menuName)){
                    weekBenefits += 2023 * order.getQuantity();
                }
            }
        }
        return weekBenefits;
    }
    private int getWeekEndBenefits(OrderList orderList, Event event, Menu menu){
        int weekendBenefits = 0;
        if(event.isWeekend()){
            for(Order order : orderList.orderList()){
                String menuName = order.getMenuName();
                if(menu.isMainDish(menuName)){
                    weekendBenefits += 2023 * order.getQuantity();
                }
            }
        }
        return weekendBenefits;
    }
    private int getSpecialBenefits(Event event){
        int specialBenefits = 0;
        if(event.isSpecialEvent()){
            specialBenefits += 1000;
        }
        return specialBenefits;
    }
    private int getFreeGiftBenefits(Integer totalPrice){
        int freeGiftBenefits = 0;
        if(totalPrice >= 120000){
            freeGiftBenefits += 25000;
        }
        return freeGiftBenefits;
    }
    public OrderInfo makeOrderInfo(OrderList orderList, Price price) {
        return new OrderInfo(orderList, price);
    }
}
