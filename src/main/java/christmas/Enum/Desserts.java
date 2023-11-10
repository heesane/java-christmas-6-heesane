package christmas.Enum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public static List<HashMap<String,Integer>> getDesserts(){
        List<HashMap<String,Integer>> desserts = new ArrayList<>();
        for(Desserts dessert : Desserts.values()){
            desserts.add(makeDessertsHashMap(dessert));
        }
        return desserts;
    }
    private static HashMap<String,Integer> makeDessertsHashMap(Desserts dessert){
        HashMap<String,Integer> dessertHashMap = new HashMap<>();
        dessertHashMap.put(dessert.getName(),dessert.getPrice());
        return dessertHashMap;
    }
}
