package Exceptions;

public class WrongGraphTypeException extends Exception {
    public WrongGraphTypeException(){
        super("You try to use this method on a wrong type of graph");
    }
}
