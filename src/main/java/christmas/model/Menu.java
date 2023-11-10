package christmas.model;

import christmas.Enum.Appetizers;
import christmas.Enum.Desserts;
import christmas.Enum.Drinks;
import christmas.Enum.MainDishes;

import java.util.*;

public class Menu {
    private final List<String> appetizers;
    private final List<String> desserts;
    private final List<String> mainDishes;
    private final List<String> drinks;

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
}
