package christmas.Enum;

public enum MainDishes {
    T_Bone_Steak("티본스테이크", "55,000", 55000),
    BBQ_Ribs("바비큐립", "54,000", 54000),
    Seafood_Pasta("해산물파스타", "35,000", 35000),
    Christmas_Pasta("크리스마스파스타", "25,000", 25000);
    private final String name;
    private final String priceString;
    private final int price;

    MainDishes(String name, String priceString, int price) {
        this.name = name;
        this.priceString = priceString;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPriceString() {
        return priceString;
    }

    public int getPrice() {
        return price;
    }
}
