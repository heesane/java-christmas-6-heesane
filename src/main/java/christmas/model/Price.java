package christmas.model;

public class Price {
    private Integer totalPrice;
    private Integer discountPrice;
    private Integer totalPriceAfterDiscount;

    public Price(){
        this.totalPrice = 0;
        this.discountPrice = 0;
        this.totalPriceAfterDiscount = 0;
    }
    public Price(Integer totalPrice, Integer discountPrice, Integer totalPriceAfterDiscount){
        this.totalPrice = totalPrice;
        this.discountPrice = discountPrice;
        this.totalPriceAfterDiscount = totalPriceAfterDiscount;
    }
    public Integer totalPrice(){
        return totalPrice;
    }
    public Integer discountPrice(){
        return discountPrice;
    }
    public Integer totalPriceAfterDiscount(){
        calculatorTotalPrice();
        return totalPriceAfterDiscount;
    }
    private void calculatorTotalPrice(){
        totalPriceAfterDiscount = totalPrice - discountPrice;
    }
    public void plusTotalPrice(Integer price){
        totalPrice += price;
    }
    public void plusDiscountPrice(Integer price){
        discountPrice += price;
    }
}
