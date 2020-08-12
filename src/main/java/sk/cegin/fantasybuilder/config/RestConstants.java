package sk.cegin.fantasybuilder.config;

public final class RestConstants {
    private RestConstants() {
    }

    public static final String JSON_CONTENT_TYPE = "application/json";

    public static final String CHARACTERS_FANTASY_MAPPING_PATH = "/characters";
    public static final String CHAR_NAME_MAPPING_PATH = "/charname";

    public static final String CHARACTER_FANTASY_ID_PLACEHOLDER = "character-id";
    public static final String ID_PLACEHOLDER = "id";

    public static final String ID_PLACEHOLDER_PATH = "/{" + ID_PLACEHOLDER + "}";
    public static final String CHARACTER_FANTASY_ID_PLACEHOLDER_PATH = "/{" + CHARACTER_FANTASY_ID_PLACEHOLDER + "}";
}
