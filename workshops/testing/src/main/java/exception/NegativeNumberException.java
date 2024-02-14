package exception;

public class NegativeNumberException extends IllegalArgumentException {

    public NegativeNumberException() {
    
        super("Negative numbers can't be used in this context.");
    
    }

}
