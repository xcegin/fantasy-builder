package sk.cegin.fantasybuilder.exception;

public class RaceNotFoundException extends RuntimeException {

    public RaceNotFoundException(Long id) {
        super("Could not find race with id: " + id);
    }
}
