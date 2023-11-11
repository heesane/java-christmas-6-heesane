package christmas.Enum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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

    public String getMenuName() {
        return name;
    }

    public String getStringPrice() {
        return stringPrice;
    }

    public Integer getIntPrice() {
        return price;
    }

    public static List<HashMap<String,Integer>> getDesserts(){
        return Arrays.stream(Desserts.values()).
                map(Desserts::makeDessertsHashMap).
                toList();
    }
    private static HashMap<String,Integer> makeDessertsHashMap(Desserts dessert){
        HashMap<String,Integer> dessertHashMap = new HashMap<>();
        dessertHashMap.put(dessert.getMenuName(),dessert.getIntPrice());
        return dessertHashMap;
    }
}
