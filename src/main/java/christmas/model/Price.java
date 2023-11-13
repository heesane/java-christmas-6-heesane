package christmas.model;

import java.text.DecimalFormat;

import static christmas.constant.EventConstant.*;
import static christmas.constant.stringConstant.EMPTY;
import static christmas.constant.stringConstant.PRICE_EMPTY;


public record Price(Integer totalPrice, Benefits benefits) {
    public String getTotalPriceAfterBenefits() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(totalPrice - benefits.getTotalBenefits() + benefits.getFreeGiftBenefits());
    }

    public String totalPriceToString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(this.totalPrice());
    }

    public String freeGift() {
        if (this.benefits.getFreeGiftBenefits() == 0) {
            return EMPTY.getMessage();
        }
        return CHAMPAGNE.getMessage();
    }

    public String christmasBenefitsToString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        if (this.benefits.getChristmasBenefits() == 0) {
            return null;
        }
        return CHRISTMAS_D_DAY_MESSAGE.getMessage() +
                decimalFormat.format(this.benefits.getChristmasBenefits()) +
                PRICE.getMessage();
    }

    public String weekBenefitsToString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        if (this.benefits.getWeekBenefits() == 0) {
            return null;
        }
        return WEEKDAY_DISCOUNT_MESSAGE.getMessage() +
                decimalFormat.format(this.benefits.getWeekBenefits()) +
                PRICE.getMessage();
    }

    public String weekendBenefitsToString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        if (this.benefits.getWeekendBenefits() == 0) {
            return null;
        }
        return WEEKEND_DISCOUNT_MESSAGE.getMessage() +
                decimalFormat.format(this.benefits.getWeekendBenefits()) +
                PRICE.getMessage();
    }

    public String specialBenefitsToString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        if (this.benefits.getSpecialBenefits() == 0) {
            return null;
        }
        return SPECIAL_DISCOUNT_MESSAGE.getMessage() +
                decimalFormat.format(this.benefits.getSpecialBenefits()) +
                PRICE.getMessage();
    }

    public String freeGiftBenefitsToString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        if (this.benefits.getFreeGiftBenefits() == 0) {
            return null;
        }
        return FREE_GIFT_MESSAGE.getMessage() +
                decimalFormat.format(this.benefits.getFreeGiftBenefits()) +
                PRICE.getMessage();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        checkEvent(sb);
        if (sb.isEmpty()) {
            return EMPTY.getMessage();
        }
        return sb.toString();
    }

    private void checkEvent(StringBuilder sb) {
        if (christmasBenefitsToString() != null) sb.append(christmasBenefitsToString());
        if (weekBenefitsToString() != null) sb.append(weekBenefitsToString());
        if (weekendBenefitsToString() != null) sb.append(weekendBenefitsToString());
        if (specialBenefitsToString() != null) sb.append(specialBenefitsToString());
        if (freeGiftBenefitsToString() != null) sb.append(freeGiftBenefitsToString());
    }

    public String benefitPrice() {
        if (this.benefits.getTotalBenefits() == 0) {
            return PRICE_EMPTY.getMessage();
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(-1L * benefits.getTotalBenefits());
    }

    public Benefits getBenefits() {
        return this.benefits;
    }
}