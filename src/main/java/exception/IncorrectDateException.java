package exception;

public class IncorrectDateException extends Exception {
    public IncorrectDateException(String message) {
        super("Incorrect date. Date is not accepted by NBP web API. " + message);
    }
}


