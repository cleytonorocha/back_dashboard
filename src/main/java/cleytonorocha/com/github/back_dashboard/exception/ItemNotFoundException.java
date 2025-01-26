package cleytonorocha.com.github.back_dashboard.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException() {
        super("Item not found in the database. Please check the ID and try again.");
    }
}
