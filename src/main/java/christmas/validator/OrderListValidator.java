package christmas.validator;

import christmas.exception.order.InvalidOrderFormatException;
import christmas.model.Menu;

import static christmas.constant.stringConstant.COMMA;
import static christmas.constant.stringConstant.DASH;

public class OrderListValidator {
    private static final Integer AMOUNT_INDEX = 1;
    private static final Integer MENU_INDEX = 0;
    private static final Integer MAX_AMOUNT = 20;

    public void isValidOrderList(String orderList) {
        if (!orderList.trim().matches("(([ㄱ-ㅣ가-힣]*)+-\\b(?:[1-9]|1\\d|20)\\b)(,([ㄱ-ㅣ가-힣]*)+-\\b(?:[1-9]|1\\d|20)\\b)*")) {
            throw new InvalidOrderFormatException();
        }
    }

    public void checkOrderAmount(String orderList) {
        int checkAmount = 0;
        String[] orderListSplit = orderList.split(COMMA.getMessage());
        for (String s : orderListSplit) {
            String[] menu = s.split(DASH.getMessage());
            int amount = Integer.parseInt(menu[AMOUNT_INDEX]);
            checkAmount += amount;
        }
        if (checkAmount > MAX_AMOUNT) {
            throw new InvalidOrderFormatException();
        }
    }

    public void checkOrderMenuInMenu(String orderList) {
        Menu allMenu = new Menu();
        String[] orderListSplit = orderList.split(COMMA.getMessage());
        for (String s : orderListSplit) {
            String[] menu = s.split(DASH.getMessage());
            if (!allMenu.isMenu(menu[MENU_INDEX])) {
                throw new InvalidOrderFormatException();
            }
        }
    }
}