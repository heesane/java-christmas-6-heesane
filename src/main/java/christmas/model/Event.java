package christmas.model;

import christmas.Enum.Week;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Event {
    private final Integer CHRISTMAS_YEAR = 2023;
    private final Integer CHRISTMAS_MONTH = 12;
    private final Integer CHRISTMAS_EVENT_END = 25;
    private final Integer CHRISTMAS_EVENT_START = 1;
    private final List<Integer> SPECIAL_EVENT = Arrays.asList(3, 10, 17, 24, 25, 31);
    private final Reservation date;

    public Event(Reservation date) {
        this.date = date;
    }

    public Reservation getDate() {
        return date;
    }

    public boolean isChristmasDday() {
        Integer reservationDay = date.reservationDay();
        return CHRISTMAS_EVENT_START <= reservationDay && reservationDay <= CHRISTMAS_EVENT_END;
    }

    public boolean isWeek() {
        LocalDate localDate = LocalDate.of(CHRISTMAS_YEAR, CHRISTMAS_MONTH, date.reservationDay());
        return localDate.getDayOfWeek().getValue() <= Week.THURSDAY.getDay() || localDate.getDayOfWeek().getValue() == Week.SUNDAY.getDay();
    }

    public boolean isWeekend() {
        LocalDate localDate = LocalDate.of(CHRISTMAS_YEAR, CHRISTMAS_MONTH, date.reservationDay());
        return localDate.getDayOfWeek().getValue() == Week.FRIDAY.getDay() || localDate.getDayOfWeek().getValue() == Week.SATURDAY.getDay();
    }

    public boolean isSpecialEvent() {
        return SPECIAL_EVENT.contains(date.reservationDay());
    }
}
