package christmas.Enum;

import java.util.ArrayList;
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

    public int getPrice() {
        return price;
    }
    public static List<String> getMainDishes(){
        List<String> mainDishes = new ArrayList<>();
        for(MainDishes mainDish : MainDishes.values()){
            mainDishes.add(mainDish.getName());
        }
        return mainDishes;
    }
    public static Integer getPriceByMenuName(String menuName){
        for(MainDishes mainDish : MainDishes.values()){
            if(mainDish.getName().equals(menuName)){
                return mainDish.getPrice();
            }
        }
        return 0;
    }
}
