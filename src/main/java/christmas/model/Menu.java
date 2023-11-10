package christmas.model;

import christmas.Enum.Appetizers;
import christmas.Enum.Desserts;
import christmas.Enum.Drinks;
import christmas.Enum.MainDishes;

import java.util.*;

public class Menu {
    private final List<HashMap<String,Integer>> appetizers;
    private final List<HashMap<String,Integer>> desserts;
    private final List<HashMap<String,Integer>> mainDishes;
    private final List<HashMap<String,Integer>> drinks;

    public Menu(){
        appetizers = Appetizers.getAppetizers();
        desserts = Desserts.getDesserts();
        mainDishes = MainDishes.getMainDishes();
        drinks = Drinks.getDrinks();
    }

    public boolean isAppetizer(String menu){
        return appetizers.contains(menu);
    }
    public boolean isDessert(String menu){
        return desserts.contains(menu);
    }
    public boolean isMainDish(String menu){
        return mainDishes.contains(menu);
    }
    public boolean isDrink(String menu){
        return drinks.contains(menu);
    }
    public List<String> allMenus(){
        List<String> allMenus = new ArrayList<>();
        allMenus.addAll(appetizers);
        allMenus.addAll(desserts);
        allMenus.addAll(mainDishes);
        allMenus.addAll(drinks);
        return allMenus;
    }
}
