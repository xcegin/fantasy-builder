package sk.cegin.fantasybuilder.exception;

public class CharacterFantasyNotFoundException extends RuntimeException {

    public CharacterFantasyNotFoundException(Long id) {
        super("Could not find character with id: " + id);
    }
}
