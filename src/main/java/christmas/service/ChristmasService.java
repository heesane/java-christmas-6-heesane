package christmas.service;

import christmas.model.*;
import christmas.parser.ParserOrderList;
import christmas.parser.ParserReservation;

import static christmas.service.constant.ServiceMessages.*;

public class ChristmasService {
    private final ParserReservation parserReservation;
    private final ParserOrderList parserOrderList;

    public ChristmasService() {
        this.parserReservation = new ParserReservation();
        this.parserOrderList = new ParserOrderList();
    }

    public Reservation makeReservation(String reservationDay) {
        return parserReservation.parseReservation(reservationDay);
    }

    public OrderList makeOrderList(String orderList) {
        return parserOrderList.parseOrderList(orderList);
    }

    public Event makeEvent(Reservation date) {
        return new Event(date);
    }

    public Price makePrice(OrderList orderList, Event event) {
        Menu menu = new Menu();
        Integer totalPrice = getTotalPrice(orderList, menu);
        if (totalPrice < EVENT_LIMIT.getPrice()) {
            return new Price(totalPrice, new Benefits());
        }
        return createPrice(orderList, event, totalPrice, menu);
    }

    private Price createPrice(OrderList orderList, Event event, Integer totalPrice, Menu menu) {
        Benefits benefits = new Benefits(
                getChristmasBenefits(event),
                getWeekBenefits(orderList, event, menu),
                getWeekEndBenefits(orderList, event, menu),
                getSpecialBenefits(event),
                getFreeGiftBenefits(totalPrice));
        return new Price(totalPrice,benefits);
    }

    private int getTotalPrice(OrderList orderList, Menu menu) {
        int totalPrice = INIT_PRICE.getPrice();
        for (Order order : orderList.orderList()) {
            String menuName = order.getMenuName();
            totalPrice += menu.getMenuPrice(menuName) * order.getQuantity();
        }
        return totalPrice;
    }

    private int getChristmasBenefits(Event event) {
        int christmasBenefits = INIT_PRICE.getPrice();
        if (event.isChristmasDday()) {
            christmasBenefits += (event.getDate().reservationDay() - 1) * CHRISTMAS_BENEFIT.getPrice() + CHRISTMAS_INIT_BENEFIT.getPrice();
        }
        return christmasBenefits;
    }

    private int getWeekBenefits(OrderList orderList, Event event, Menu menu) {
        int weekBenefits = INIT_PRICE.getPrice();
        if (event.isWeek()) {
            weekBenefits = calculateWeekBenefits(orderList, menu, weekBenefits);
        }
        return weekBenefits;
    }

    private int calculateWeekBenefits(OrderList orderList, Menu menu, int weekBenefits) {
        for (Order order : orderList.orderList()) {
            String menuName = order.getMenuName();
            weekBenefits = checkDessertBenefits(menu, order, menuName, weekBenefits);
        }
        return weekBenefits;
    }

    private int checkDessertBenefits(Menu menu, Order order, String menuName, int weekBenefits) {
        if (menu.isDessert(menuName)) {
            weekBenefits += WEEK_BENEFIT.getPrice() * order.getQuantity();
        }
        return weekBenefits;
    }

    private int getWeekEndBenefits(OrderList orderList, Event event, Menu menu) {
        int weekendBenefits = INIT_PRICE.getPrice();
        if (event.isWeekend()) {
            weekendBenefits = calculateWeekendBenefits(orderList, menu, weekendBenefits);
        }
        return weekendBenefits;
    }

    private int calculateWeekendBenefits(OrderList orderList, Menu menu, int weekendBenefits) {
        for (Order order : orderList.orderList()) {
            String menuName = order.getMenuName();
            weekendBenefits = checkMainDIshBenefits(menu, order, menuName, weekendBenefits);
        }
        return weekendBenefits;
    }

    private int checkMainDIshBenefits(Menu menu, Order order, String menuName, int weekendBenefits) {
        if (menu.isMainDish(menuName)) {
            weekendBenefits += WEEKEND_BENEFIT.getPrice() * order.getQuantity();
        }
        return weekendBenefits;
    }

    private int getSpecialBenefits(Event event) {
        int specialBenefits = INIT_PRICE.getPrice();
        if (event.isSpecialEvent()) {
            specialBenefits += SPECIAL_BENEFIT.getPrice();
        }
        return specialBenefits;
    }

    private int getFreeGiftBenefits(Integer totalPrice) {
        int freeGiftBenefits = INIT_PRICE.getPrice();
        if (totalPrice >= FREE_GIFT_LIMIT.getPrice()) {
            freeGiftBenefits += FREE_GIFT_BENEFIT.getPrice();
        }
        return freeGiftBenefits;
    }

    public OrderInfo makeOrderInfo(OrderList orderList, Price price) {
        return new OrderInfo(orderList, price);
    }
}
