package Exceptions;

public class NoEdgeInGraphException extends Exception {
    public NoEdgeInGraphException(){
        super("No such edge in this graph");
    }
}
