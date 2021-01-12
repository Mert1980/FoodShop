package be.intecbrussel.foodshop.exception;

public class FoodAlreadyInStockException extends Exception{
    public FoodAlreadyInStockException() {
        super();
    }

    public FoodAlreadyInStockException(String message) {
        super(message);
    }

    public FoodAlreadyInStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public FoodAlreadyInStockException(Throwable cause) {
        super(cause);
    }

    protected FoodAlreadyInStockException(String message, Throwable cause, boolean enableSuppression,
                                          boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
