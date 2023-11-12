package christmas.Enum;

public enum Week {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private final Integer day;
    Week(Integer day){
        this.day = day;
    }
    public Integer getDay() {
        return day;
    }
}
