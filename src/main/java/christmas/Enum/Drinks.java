package christmas.Enum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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

    public Integer getIntPrice() {
        return price;
    }

    public String getStringPrice() {
        return stringPrice;
    }

    public String getMenuName() {
        return name;
    }
    public static List<HashMap<String,Integer>> getDrinks(){
        return Arrays.stream(Drinks.values()).
                map(Drinks::makeDrinksHashMap).
                toList();
    }
    private static HashMap<String,Integer> makeDrinksHashMap(Drinks drink){
        HashMap<String,Integer> drinksHashMap = new HashMap<>();
        drinksHashMap.put(drink.getMenuName(),drink.getIntPrice());
        return drinksHashMap;
    }
}
