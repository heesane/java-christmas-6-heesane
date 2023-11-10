package christmas.Enum;

import java.util.ArrayList;
import java.util.List;

public enum Drinks {
    Zero_Cola("제로콜라", "3,000", 3000),
    Red_Wine("레드와인", "60,000", 60000),
    Champagne("샴페인", "25,000", 25000);

    private final String name;
    private final String stringPrice;
    private final Integer price;
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
    public static List<String> getDrinks(){
        List<String> drinks = new ArrayList<>();
        for(Drinks drink : Drinks.values()){
            drinks.add(drink.getName());
        }
        return drinks;
    }
}
