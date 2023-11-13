package christmas.Enum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public enum Appetizers {
    AL_SONG_SOUP("알송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000);

    private final String menuName;
    private final Integer intPrice;

    Appetizers(String menuName, Integer intPrice) {
        this.menuName = menuName;
        this.intPrice = intPrice;
    }

    public String getMenuName() {
        return menuName;
    }

    public Integer getPrice() {
        return intPrice;
    }

    public static List<HashMap<String, Integer>> getAppetizers() {
        return Arrays.stream(Appetizers.values()).
                map(Appetizers::makeAppetizerHashMap).
                toList();
    }

    private static HashMap<String, Integer> makeAppetizerHashMap(Appetizers appetizer) {
        HashMap<String, Integer> appetizerHashMap = new HashMap<>();
        appetizerHashMap.put(appetizer.getMenuName(), appetizer.getPrice());
        return appetizerHashMap;
    }
}
