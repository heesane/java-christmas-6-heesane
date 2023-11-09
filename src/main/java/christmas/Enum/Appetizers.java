package christmas.Enum;

public enum Appetizers {
    AL_SONG_SOUP("알송이수프","6,000",6000),
    TAPAS("타파스","5,500",5500),
    CAESAR_SALAD("시저샐러드","8,000",8000);

    private String menuName;
    private String stringPrice;
    private Integer intPrice;

    Appetizers(String menuName, String stringPrice, Integer intPrice){
        this.menuName = menuName;
        this.stringPrice = stringPrice;
        this.intPrice = intPrice;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getStringPrice() {
        return stringPrice;
    }

    public Integer getIntPrice() {
        return intPrice;
    }
}
