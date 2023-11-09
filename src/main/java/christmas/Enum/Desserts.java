package christmas.Enum;

public enum Desserts {
    Choco_Cake("초코케이크", "15,000", 15000),
    Ice_Cream("아이스크림", "5,000", 5000);

    private final String name;
    private final String stringPrice;
    private final Integer price;
    Desserts(String name, String stringPrice, Integer price) {
        this.name = name;
        this.stringPrice = stringPrice;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getStringPrice() {
        return stringPrice;
    }

    public Integer getPrice() {
        return price;
    }
}
