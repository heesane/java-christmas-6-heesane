package christmas.exception.order;

import christmas.exception.order.constant.OrderExceptionMessages;

public class InvalidOrderFormatException extends IllegalArgumentException{
    public InvalidOrderFormatException(){
        super(OrderExceptionMessages.INVALID_ORDER_FORMAT.getMessage());
    }
}
