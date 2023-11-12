package christmas.model;

import java.text.DecimalFormat;

public record Price(Integer totalPrice, Integer christmasBenefits, Integer weekBenefits, Integer weekendBenefits, Integer specialBenefits, Integer freeGiftBenefits) {
    public String getTotalPriceAfterBenefits() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(totalPrice - getTotalBenefits());
    }
    public Integer getTotalBenefits(){
        return christmasBenefits + weekBenefits + weekendBenefits + specialBenefits;
    }
    public String totalPriceToString(){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(this.totalPrice());
    }
    public String freeGift(){
        if(this.freeGiftBenefits() == 0){
            return "없음";
        }
        return "샴페인 1개";
    }
    public String christmasBenefitsToString(){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        if(this.christmasBenefits() == 0){
            return null;
        }
        return "크리스마스 디데이 할인: -"+decimalFormat.format(this.christmasBenefits())+"원\n";
    }
    public String weekBenefitsToString(){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        if(this.weekBenefits() == 0){
            return null;
        }
        return "평일 할인: -"+decimalFormat.format(this.weekBenefits())+"원\n";
    }
    public String weekendBenefitsToString(){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        if(this.weekendBenefits() == 0){
            return null;
        }
        return  "주말 할인: -"+decimalFormat.format(this.weekendBenefits())+"원\n";
    }
    public String specialBenefitsToString(){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        if(this.specialBenefits() == 0){
            return null;
        }
        return "특별 할인: -"+decimalFormat.format(this.weekendBenefits())+"원\n";
    }
    public String freeGiftBenefitsToString(){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        if(this.freeGiftBenefits() == 0){
            return null;
        }
        return "증정 이벤트: -"+decimalFormat.format(this.weekendBenefits())+"원\n";
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
            return "없음";
        }
        return sb.toString();
    }

    public String benefitPrice(){
        if(getTotalBenefits() == 0){
            return "없음";
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format("-"+getTotalBenefits());
    }
}
