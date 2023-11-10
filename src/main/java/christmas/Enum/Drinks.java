package christmas.Enum;

import java.util.ArrayList;
import java.util.HashMap;
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
    public static List<HashMap<String,Integer>> getDrinks(){
        List<HashMap<String,Integer>> appetizers = new ArrayList<>();
        for(Drinks drinks : Drinks.values()){
            appetizers.add(makeDrinksHashMap(drinks));
        }
        return appetizers;
    }
    private static HashMap<String,Integer> makeDrinksHashMap(Drinks drinks){
        HashMap<String,Integer> drinksHashMap = new HashMap<>();
        drinksHashMap.put(drinks.getMenuName(),drinks.getIntPrice());
        return drinksHashMap;
    }
    public static Integer getPriceByMenuName(String menuName){
        for(Drinks drink : Drinks.values()){
            if(drink.getName().equals(menuName)){
                return drink.getPrice();
            }
        }
        return 0;
    }
}
