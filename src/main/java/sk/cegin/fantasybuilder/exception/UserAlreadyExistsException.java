package sk.cegin.fantasybuilder.exception;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(Class<?> clazz, Object email) {
        super(clazz.getSimpleName() + " already exists with email: " + email.toString());
    }
}
