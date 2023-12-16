package exceptions;

public class UnknownValueException extends RuntimeException{
    public UnknownValueException(String msg){
        super("An issue occurred processing value." + msg);
    }
}
