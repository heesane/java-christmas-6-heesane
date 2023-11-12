package christmas.Enum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public enum MainDishes {
    T_Bone_Steak("티본스테이크", 55000),
    BBQ_Ribs("바비큐립",  54000),
    Seafood_Pasta("해산물파스타", 35000),
    Christmas_Pasta("크리스마스파스타", 25000);
    private final String name;
    private final Integer price;
    MainDishes(String name,Integer price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public static List<HashMap<String,Integer>> getMainDishes(){
        return Arrays.stream(MainDishes.values()).
                map(MainDishes::makeMainDishesHashMap).
                toList();
    }
    private static HashMap<String,Integer> makeMainDishesHashMap(MainDishes mainDish){
        HashMap<String,Integer> mainDishesHashMap = new HashMap<>();
        mainDishesHashMap.put(mainDish.getName(),mainDish.getPrice());
        return mainDishesHashMap;
    }
}
