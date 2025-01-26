package cleytonorocha.com.github.back_dashboard.exception;

public class EnumIdException extends RuntimeException {
    public EnumIdException() {
        super("Invalid Enum ID provided.");
    }
}
