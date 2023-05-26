package Exceptions;

public class NoVertexInGraphException extends Exception{
    public NoVertexInGraphException(){
        super("No such vertex in this graph");
    }
}
