package christmas.model;

public record Price(Integer totalPrice, Integer christmasBenefits, Integer weekBenefits, Integer weekendBenefits, Integer specialBenefits, Integer discountPrice) {
    public Integer getTotalPriceAfterBenefits() {
        return totalPrice - getTotalBenefits();
    }
    private Integer getTotalBenefits(){
        return christmasBenefits + weekBenefits + weekendBenefits + specialBenefits;
    }
}
