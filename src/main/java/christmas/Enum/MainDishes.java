package christmas.Enum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public enum MainDishes {
    T_Bone_Steak("티본스테이크", "55,000", 55000),
    BBQ_Ribs("바비큐립", "54,000", 54000),
    Seafood_Pasta("해산물파스타", "35,000", 35000),
    Christmas_Pasta("크리스마스파스타", "25,000", 25000);
    private final String name;
    private final String stringPrice;
    private final Integer price;

    MainDishes(String name, String stringPrice, Integer price) {
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

    public int getIntPrice() {
        return price;
    }
    public static List<HashMap<String,Integer>> getMainDishes(){
        return Arrays.stream(MainDishes.values()).
                map(MainDishes::makeMainDishesHashMap).
                toList();
    }
    private static HashMap<String,Integer> makeMainDishesHashMap(MainDishes mainDish){
        HashMap<String,Integer> mainDishesHashMap = new HashMap<>();
        mainDishesHashMap.put(mainDish.getName(),mainDish.getIntPrice());
        return mainDishesHashMap;
    }
}
