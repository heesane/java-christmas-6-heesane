package christmas.view;

import christmas.Enum.Badge;
import christmas.model.Bill;
import christmas.model.Price;
import christmas.model.Reservation;
import christmas.view.constant.ViewMessages;

import static christmas.constant.stringConstant.EMPTY;
import static christmas.constant.stringConstant.PRICE;

public class OutputView {
    private static void printConstantMessage(String message) {
        System.out.println(message);
    }

    private static void printWhiteSpace() {
        System.out.println();
    }

    private void printVariable(String message) {
        System.out.println(message);
    }

    public void printWelcome() {
        printConstantMessage(ViewMessages.WELCOME_MESSAGE.getMessage());
    }

    public void printRequestReservationDate() {
        printConstantMessage(ViewMessages.REQUEST_RESERVATION_DATE_MESSAGE.getMessage());
    }

    public void printRequestMenuAndAmount() {
        printConstantMessage(ViewMessages.REQUEST_MENU_AND_AMOUNT_MESSAGE.getMessage());
    }

    public void printOrderList(Reservation date, Bill bill) {
        printConstantMessage(date.toString() + ViewMessages.EVENT_PREVIEW_MESSAGE.getMessage());
        printWhiteSpace();
        printConstantMessage(ViewMessages.ORDER_LIST_MESSAGE.getMessage());
        printVariable(bill.orderList().toString());
    }

    public void printTotalPrice(Price price) {
        printConstantMessage(ViewMessages.TOTAL_PRICE_MESSAGE.getMessage());
        printVariable(price.totalPriceToString() + PRICE.getMessage());
    }

    public void printFreeGiftList(Price price) {
        printWhiteSpace();
        printConstantMessage(ViewMessages.FREE_GIFT_LIST_MESSAGE.getMessage());
        printVariable(price.freeGift());
    }

    public void printEventMessage(Bill bill) {
        printWhiteSpace();
        printConstantMessage(ViewMessages.EVENT_MESSAGE.getMessage());
        printVariable(bill.price().toString());
    }

    public void printDiscount(Price price) {
        printWhiteSpace();
        printConstantMessage(ViewMessages.DISCOUNT_MESSAGE.getMessage());
        printVariable(price.benefitPrice());
    }

    public void printTotalPriceAfterDiscount(Price price) {
        printWhiteSpace();
        printConstantMessage(ViewMessages.TOTAL_PRICE_AFTER_DISCOUNT_MESSAGE.getMessage());
        printVariable(price.getTotalPriceAfterBenefits() + PRICE.getMessage());
    }

    public void printBadgeMessage(Price price) {
        printWhiteSpace();
        printConstantMessage(ViewMessages.BADGE_MESSAGE.getMessage());
        printBadge(price);
    }

    private void printBadge(Price price) {
        checkBadgePrice(price);
        isStarBadge(price);
        isTreeBadge(price);
        isSantaBadge(price);
    }

    private void checkBadgePrice(Price price) {
        if (price.getBenefits().getTotalBenefits() < Badge.BADGE_STAR.getPrice()) {
            printConstantMessage(EMPTY.getMessage());
        }
    }

    private void isStarBadge(Price price) {
        if (price.getBenefits().getTotalBenefits() < Badge.BADGE_TREE.getPrice() &&
                price.getBenefits().getTotalBenefits() >= Badge.BADGE_STAR.getPrice()) {
            printVariable(Badge.BADGE_STAR.getBadgeName());
        }
    }

    private void isTreeBadge(Price price) {
        if (price.getBenefits().getTotalBenefits() < Badge.BADGE_SANTA.getPrice() &&
                price.getBenefits().getTotalBenefits() >= Badge.BADGE_TREE.getPrice()) {
            printVariable(Badge.BADGE_TREE.getBadgeName());
        }
    }

    private void isSantaBadge(Price price) {
        if (price.getBenefits().getTotalBenefits() >= Badge.BADGE_SANTA.getPrice()) {
            printVariable(Badge.BADGE_SANTA.getBadgeName());
        }
    }

    public void printExceptionMessage(Exception e) {
        printWhiteSpace();
        printConstantMessage(e.getMessage());
    }
}
