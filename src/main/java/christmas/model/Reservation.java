package christmas.model;

public record Reservation(Integer reservationDay) {
    @Override
    public String toString(){
        return "12월 "+reservationDay.toString()+"일";
    }
}
