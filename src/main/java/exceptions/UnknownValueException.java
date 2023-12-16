package exceptions;

public class UnknownNoteException extends RuntimeException{
    public UnknownNoteException(String msg){
        super("An issue occurred processing a note or base note value. " + msg
        );
    }
}
