package christmas.model;

import java.text.DecimalFormat;

import static christmas.constant.EventConstant.*;
import static christmas.constant.stringConstant.*;

public record Price(Integer totalPrice, Integer christmasBenefits, Integer weekBenefits, Integer weekendBenefits, Integer specialBenefits, Integer freeGiftBenefits) {
    public String getTotalPriceAfterBenefits() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(totalPrice - getTotalBenefits() + freeGiftBenefits);
    }
    public Integer getTotalBenefits(){
        return christmasBenefits + weekBenefits + weekendBenefits + specialBenefits+ freeGiftBenefits;
    }
    public String totalPriceToString(){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(this.totalPrice());
    }
    public String freeGift(){
        if(this.freeGiftBenefits() == 0){
            return EMPTY.getMessage();
        }
        return CHAMPAGNE.getMessage();
    }
    public String christmasBenefitsToString(){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        if(this.christmasBenefits() == 0){
            return null;
        }
        return CHRISTMAS_D_DAY_MESSAGE.getMessage()+
                decimalFormat.format(this.christmasBenefits())+
                PRICE.getMessage();
    }
    public String weekBenefitsToString(){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        if(this.weekBenefits() == 0){
            return null;
        }
        return WEEKDAY_DISCOUNT_MESSAGE.getMessage()+
                decimalFormat.format(this.weekBenefits())+
                PRICE.getMessage();
    }
    public String weekendBenefitsToString(){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        if(this.weekendBenefits() == 0){
            return null;
        }
        return  WEEKEND_DISCOUNT_MESSAGE.getMessage()+
                decimalFormat.format(this.weekendBenefits())+
                PRICE.getMessage();
    }
    public String specialBenefitsToString(){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        if(this.specialBenefits() == 0){
            return null;
        }
        return SPECIAL_DISCOUNT_MESSAGE.getMessage()+
                decimalFormat.format(this.specialBenefits())+
                PRICE.getMessage();
    }
    public String freeGiftBenefitsToString(){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        if(this.freeGiftBenefits() == 0){
            return null;
        }
        return FREE_GIFT_MESSAGE.getMessage()+
                decimalFormat.format(this.freeGiftBenefits())+
                PRICE.getMessage();
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if (christmasBenefitsToString() != null){
            sb.append(christmasBenefitsToString());
        }
        if(weekBenefitsToString() != null){
            sb.append(weekBenefitsToString());
        }
        if(weekendBenefitsToString() != null){
            sb.append(weekendBenefitsToString());
        }
        if(specialBenefitsToString() != null){
            sb.append(specialBenefitsToString());
        }
        if(freeGiftBenefitsToString() != null){
            sb.append(freeGiftBenefitsToString());
        }
        if(sb.isEmpty()){
            return EMPTY.getMessage();
        }
        return sb.toString();
    }

    public String benefitPrice(){
        if(getTotalBenefits() == 0){
            return PRICE_EMPTY.getMessage();
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(-1 *getTotalBenefits());
    }
}
