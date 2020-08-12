package sk.cegin.fantasybuilder.exception;

public class CharNameNotFoundException extends RuntimeException {

    public CharNameNotFoundException(Long id) {
        super("Could not find character name with id: " + id);
    }
}
