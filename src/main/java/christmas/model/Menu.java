package christmas.model;

import christmas.Enum.Appetizers;
import christmas.Enum.Desserts;
import christmas.Enum.Drinks;
import christmas.Enum.MainDishes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu {
    private final List<HashMap<String, Integer>> appetizers;
    private final List<HashMap<String, Integer>> desserts;
    private final List<HashMap<String, Integer>> mainDishes;
    private final List<HashMap<String, Integer>> drinks;

    public Menu() {
        appetizers = Appetizers.getAppetizers();
        desserts = Desserts.getDesserts();
        mainDishes = MainDishes.getMainDishes();
        drinks = Drinks.getDrinks();
    }

    public boolean isDessert(String menu) {
        return checkMenu(desserts, menu);
    }

    public boolean isMainDish(String menu) {
        return checkMenu(mainDishes, menu);
    }

    public List<HashMap<String, Integer>> allMenus() {
        List<HashMap<String, Integer>> allMenus = new ArrayList<>();
        allMenus.addAll(appetizers);
        allMenus.addAll(desserts);
        allMenus.addAll(mainDishes);
        allMenus.addAll(drinks);
        return allMenus;
    }

    public Integer getMenuPrice(String menu) {
        List<HashMap<String, Integer>> allMenus = allMenus();
        for (HashMap<String, Integer> menuHashMap : allMenus) {
            if (menuHashMap.containsKey(menu)) {
                return menuHashMap.get(menu);
            }
        }
        return 0;
    }

    public boolean isMenu(String menu) {
        return checkMenu(appetizers, menu) || checkMenu(desserts, menu) || checkMenu(mainDishes, menu) || checkMenu(drinks, menu);
    }

    private boolean checkMenu(List<HashMap<String, Integer>> menuList, String menu) {
        for (HashMap<String, Integer> menuHashMap : menuList) {
            if (menuHashMap.containsKey(menu)) {
                return true;
            }
        }
        return false;
    }
}
