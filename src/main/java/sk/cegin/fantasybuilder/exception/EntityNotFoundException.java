package sk.cegin.fantasybuilder.exception;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(Class<?> clazz, Object id) {
        super(clazz.getSimpleName() + " not found with id: " + id.toString());
    }
}
