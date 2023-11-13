package christmas.model;

import static christmas.service.constant.ServiceMessages.INIT_PRICE;

public class Benefits {
    private final int christmasBenefits;
    private final int weekBenefits;
    private final int weekendBenefits;
    private final int specialBenefits;
    private final int freeGiftBenefits;

    public Benefits() {
        christmasBenefits = INIT_PRICE.getPrice();
        weekBenefits = INIT_PRICE.getPrice();
        weekendBenefits = INIT_PRICE.getPrice();
        specialBenefits = INIT_PRICE.getPrice();
        freeGiftBenefits = INIT_PRICE.getPrice();
    }

    public Benefits(int christmasBenefits, int weekBenefits, int weekendBenefits, int specialBenefits, int freeGiftBenefits) {
        this.christmasBenefits = christmasBenefits;
        this.weekBenefits = weekBenefits;
        this.weekendBenefits = weekendBenefits;
        this.specialBenefits = specialBenefits;
        this.freeGiftBenefits = freeGiftBenefits;
    }

    public int getChristmasBenefits() {
        return christmasBenefits;
    }

    public int getWeekBenefits() {
        return weekBenefits;
    }

    public int getWeekendBenefits() {
        return weekendBenefits;
    }

    public int getSpecialBenefits() {
        return specialBenefits;
    }

    public int getFreeGiftBenefits() {
        return freeGiftBenefits;
    }

    public int getTotalBenefits() {
        return christmasBenefits + weekBenefits + weekendBenefits + specialBenefits + freeGiftBenefits;
    }
}
