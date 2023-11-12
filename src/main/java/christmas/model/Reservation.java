package christmas.model;

import static christmas.constant.stringConstant.*;

public record Reservation(Integer reservationDay) {
    @Override
    public String toString(){
        return DECEMBER.getMessage()+
                MONTH.getMessage() +
                reservationDay.toString()+
                DAY.getMessage();
    }
}
