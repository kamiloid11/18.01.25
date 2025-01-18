package _180125_;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException() {
        super("Wrong login!");
    }
    public WrongLoginException(String message) {super(message);}
}