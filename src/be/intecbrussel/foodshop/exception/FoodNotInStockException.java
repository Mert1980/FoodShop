package be.intecbrussel.foodshop.exception;

public class FoodNotInStockException extends Exception{
    public FoodNotInStockException() {
        super();
    }

    public FoodNotInStockException(String message) {
        super(message);
    }

    public FoodNotInStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public FoodNotInStockException(Throwable cause) {
        super(cause);
    }

    protected FoodNotInStockException(String message, Throwable cause, boolean enableSuppression,
                                      boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
