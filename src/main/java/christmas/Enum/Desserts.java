package christmas.Enum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public enum Desserts {
    Choco_Cake("초코케이크", 15000),
    Ice_Cream("아이스크림", 5000);

    private final String menuName;
    private final Integer price;
    Desserts(String menuName, Integer price) {
        this.menuName = menuName;
        this.price = price;
    }
    public String getMenuName() {
        return menuName;
    }
    public Integer getPrice() {
        return price;
    }
    public static List<HashMap<String,Integer>> getDesserts(){
        return Arrays.stream(Desserts.values()).
                map(Desserts::makeDessertsHashMap).
                toList();
    }
    private static HashMap<String,Integer> makeDessertsHashMap(Desserts dessert){
        HashMap<String,Integer> dessertHashMap = new HashMap<>();
        dessertHashMap.put(dessert.getMenuName(),dessert.getPrice());
        return dessertHashMap;
    }
}
