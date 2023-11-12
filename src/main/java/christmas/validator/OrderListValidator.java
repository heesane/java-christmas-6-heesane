package christmas.validator;

import christmas.exception.order.InvalidOrderFormatException;
import christmas.model.Menu;

public class OrderListValidator {
    private static final String COMMA = ",";
    private static final String DASH = "-";
    private static final Integer AMOUNT_INDEX = 1;
    private static final Integer MENU_INDEX = 0;
    private static final Integer MAX_AMOUNT = 20;

    public OrderListValidator(){

    }
    public void isValidOrderList(String orderList){
        if(!orderList.trim().matches("(([ㄱ-ㅣ가-힣]*)+-\\b(?:[1-9]|1\\d|20)\\b)(,([ㄱ-ㅣ가-힣]*)+-\\b(?:[1-9]|1\\d|20)\\b)*")){
            throw new InvalidOrderFormatException();
        }
    }
    // 메뉴가 20개가 넘는지, 0개인지 체크
    public void checkOrderAmount(String orderList) {
        Integer checkAmount = 0;
        String[] orderListSplit = orderList.split(COMMA);
        for (String s : orderListSplit) {
            String[] menu = s.split(DASH);
            Integer amount = Integer.parseInt(menu[AMOUNT_INDEX]);
            checkAmount += amount;
        }
        if (checkAmount > MAX_AMOUNT) {
            throw new InvalidOrderFormatException();
        }
    }
    public void checkOrderMenuInMenu(String orderList){
        Menu allMenu = new Menu();
        String[] orderListSplit = orderList.split(COMMA);
        for (String s : orderListSplit) {
            String[] menu = s.split(DASH);
            if(!allMenu.isMenu(menu[MENU_INDEX])){
                throw new InvalidOrderFormatException();
            }
        }
    }
}
