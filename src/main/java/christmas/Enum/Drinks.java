package christmas.Enum;

public enum Drinks {
    Zero_Cola("제로콜라", "3,000", 3000),
    Red_Wine("레드와인", "60,000", 60000),
    Champagne("샴페인", "25,000", 25000);

    private String name;
    private String stringPrice;
    private Integer price;
    Drinks(String name, String stringPrice, Integer price) {
        this.name = name;
        this.stringPrice = stringPrice;
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public String getStringPrice() {
        return stringPrice;
    }

    public String getName() {
        return name;
    }
}
