package christmas.Enum;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public enum Appetizers {
    AL_SONG_SOUP("알송이수프","6,000",6000),
    TAPAS("타파스","5,500",5500),
    CAESAR_SALAD("시저샐러드","8,000",8000);

    private final String menuName;
    private final String stringPrice;
    private final Integer intPrice;

    Appetizers(String menuName, String stringPrice, Integer intPrice){
        this.menuName = menuName;
        this.stringPrice = stringPrice;
        this.intPrice = intPrice;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getStringPrice() {
        return stringPrice;
    }

    public Integer getIntPrice() {
        return intPrice;
    }
    public static List<HashMap<String,Integer>> getAppetizers(){
        List<HashMap<String,Integer>> appetizers = new ArrayList<>();
        for(Appetizers appetizer : Appetizers.values()){
            appetizers.add(makeAppetizerHashMap(appetizer));
        }
        return appetizers;
    }
    private static HashMap<String,Integer> makeAppetizerHashMap(Appetizers appetizer){
        HashMap<String,Integer> appetizerHashMap = new HashMap<>();
        appetizerHashMap.put(appetizer.getMenuName(),appetizer.getIntPrice());
        return appetizerHashMap;
    }
}
