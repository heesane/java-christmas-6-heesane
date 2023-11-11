package christmas.view;

import christmas.view.constant.ViewMessages;

public class OutputView {
    private static void printConstantMessage(String message){
        System.out.println(message);
    }
    private static void printWhiteSpace(){
        System.out.println();
    }
    public void printWelcome(){
        printConstantMessage(ViewMessages.WELCOME_MESSAGE.getMessage());
    }
    public void printRequestReservationDate(){
        printConstantMessage(ViewMessages.REQUEST_RESERVATION_DATE_MESSAGE.getMessage());
    }
    public void printRequestMenuAndAmount(){
        printConstantMessage(ViewMessages.REQUEST_MENU_AND_AMOUNT_MESSAGE.getMessage());
    }
    public void printEventPreview(){
        printWhiteSpace();
        printConstantMessage(ViewMessages.EVENT_PREVIEW_MESSAGE.getMessage());
    }
    public void printOrderList(){
        printWhiteSpace();
        printConstantMessage(ViewMessages.ORDER_LIST_MESSAGE.getMessage());
    }
    public void printTotalPrice(){
        printWhiteSpace();
        printConstantMessage(ViewMessages.TOTAL_PRICE_MESSAGE.getMessage());
    }
    public void printFreeGiftList(){
        printWhiteSpace();
        printConstantMessage(ViewMessages.FREE_GIFT_LIST_MESSAGE.getMessage());
    }
    public void printEventMessage(){
        printWhiteSpace();
        printConstantMessage(ViewMessages.EVENT_MESSAGE.getMessage());
    }
    public void printDiscount(){
        printWhiteSpace();
        printConstantMessage(ViewMessages.DISCOUNT_MESSAGE.getMessage());
    }
    public void printTotalPriceAfterDiscount(){
        printWhiteSpace();
        printConstantMessage(ViewMessages.TOTAL_PRICE_AFTER_DISCOUNT_MESSAGE.getMessage());
    }
    public void printBadgeMessage(){
        printWhiteSpace();
        printConstantMessage(ViewMessages.BADGE_MESSAGE.getMessage());
    }
    public void printExceptionMessage(Exception e){
        printWhiteSpace();
        printConstantMessage(e.getMessage());
    }
}
