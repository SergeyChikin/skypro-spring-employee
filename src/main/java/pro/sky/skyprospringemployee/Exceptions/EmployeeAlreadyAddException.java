package pro.sky.skyprospringemployee.Exceptions;

public class EmployeeAlreadyAddException extends RuntimeException {
    public EmployeeAlreadyAddException(String message) {
        super(message);
    }
}
