package _180125_;

public class WrongPasswordException extends Exception {
    public WrongPasswordException(String message) {
        super(message);
    }
    public WrongPasswordException(){
        super("Wrong password!");
    }
}