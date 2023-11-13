package christmas.service;

import christmas.model.*;
import christmas.parser.ParserOrderList;
import christmas.parser.ParserReservation;

import static christmas.service.constant.ServiceMessages.*;

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
        if(totalPrice <EVENT_LIMIT.getPrice()){
            return new Price(totalPrice,INIT_PRICE.getPrice(),INIT_PRICE.getPrice(),INIT_PRICE.getPrice(),INIT_PRICE.getPrice(),INIT_PRICE.getPrice());
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
        int totalPrice = INIT_PRICE.getPrice();
        for(Order order : orderList.orderList()){
            String menuName = order.getMenuName();
            totalPrice += menu.getMenuPrice(menuName) * order.getQuantity();;
        }
        return totalPrice;
    }
    private int getChristmasBenefits(Event event){
        int christmasBenefits = INIT_PRICE.getPrice();
        if(event.isChristmasDday()){
            christmasBenefits += (event.getDate().reservationDay()-1) * CHRISTMAS_BENEFIT.getPrice() + CHRISTMAS_INIT_BENEFIT.getPrice();
        }
        return christmasBenefits;
    }
    private int getWeekBenefits(OrderList orderList, Event event, Menu menu){
        int weekBenefits = INIT_PRICE.getPrice();
        if(event.isWeek()){
            for(Order order : orderList.orderList()){
                String menuName = order.getMenuName();
                if(menu.isDessert(menuName)){
                    weekBenefits += WEEK_BENEFIT.getPrice() * order.getQuantity();
                }
            }
        }
        return weekBenefits;
    }
    private int getWeekEndBenefits(OrderList orderList, Event event, Menu menu){
        int weekendBenefits = INIT_PRICE.getPrice();
        if(event.isWeekend()){
            for(Order order : orderList.orderList()){
                String menuName = order.getMenuName();
                if(menu.isMainDish(menuName)){
                    weekendBenefits += WEEKEND_BENEFIT.getPrice() * order.getQuantity();
                }
            }
        }
        return weekendBenefits;
    }
    private int getSpecialBenefits(Event event){
        int specialBenefits = INIT_PRICE.getPrice();
        if(event.isSpecialEvent()){
            specialBenefits += SPECIAL_BENEFIT.getPrice();
        }
        return specialBenefits;
    }
    private int getFreeGiftBenefits(Integer totalPrice){
        int freeGiftBenefits = INIT_PRICE.getPrice();
        if(totalPrice >= FREE_GIFT_LIMIT.getPrice()){
            freeGiftBenefits += FREE_GIFT_BENEFIT.getPrice();
        }
        return freeGiftBenefits;
    }
    public OrderInfo makeOrderInfo(OrderList orderList, Price price) {
        return new OrderInfo(orderList, price);
    }
}
