package christmas.Enum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public enum Drinks {
    Zero_Cola("제로콜라", 3000),
    Red_Wine("레드와인", 60000),
    Champagne("샴페인", 25000);
    private final String name;
    private final Integer price;
    Drinks(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
    public Integer getPrice() {
        return this.price;
    }
    public String getMenuName() {
        return this.name;
    }
    public static List<HashMap<String,Integer>> getDrinks(){
        return Arrays.stream(Drinks.values()).
                map(Drinks::makeDrinksHashMap).
                toList();
    }
    private static HashMap<String,Integer> makeDrinksHashMap(Drinks drink){
        HashMap<String,Integer> drinksHashMap = new HashMap<>();
        drinksHashMap.put(drink.getMenuName(),drink.getPrice());
        return drinksHashMap;
    }
}
