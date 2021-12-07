package Cooking.Exceptions;

public class UnableToFireFurnace extends Exception{
    public UnableToFireFurnace(String msg, Exception exception) {
        super(msg, exception);
    }
}
