package be.intecbrussel.foodshop.exception;

public class NotEnoughFoodInStockException extends Exception{
    public NotEnoughFoodInStockException() {
        super();
    }

    public NotEnoughFoodInStockException(String message) {
        super(message);
    }

    public NotEnoughFoodInStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughFoodInStockException(Throwable cause) {
        super(cause);
    }

    protected NotEnoughFoodInStockException(String message, Throwable cause, boolean enableSuppression,
                                            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
