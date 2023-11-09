package christmas.Enum;

public enum Desserts {
    Choco_Cake("초코케이크", "15,000", 15000),
    Ice_Cream("아이스크림", "5,000", 5000);

    private String name;
    private String priceString;
    private Integer price;
    Desserts(String name, String priceString, Integer price) {
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

    public Integer getPrice() {
        return price;
    }
}
