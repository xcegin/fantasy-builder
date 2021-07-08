package sk.cegin.fantasybuilder.config;

public final class RestConstants {
    private RestConstants() {
    }

    public static final String JSON_CONTENT_TYPE = "application/json";
    public static final String TEXT_PLAIN_CONTENT_TYPE = "text/plain";

    public static final String CHARACTERS_FANTASY_MAPPING_PATH = "/characters";
    public static final String RACE_MAPPING_PATH = "/race";
    public static final String CHAR_NAME_MAPPING_PATH = "/charname";
    public static final String APPEARANCE_MAPPING_PATH = "/appearance";
    public static final String USER_MAPPING_PATH = "/user";
    public static final String REGISTRATION_MAPPING_PATH = USER_MAPPING_PATH + "/registration";
    public static final String CONFIRM_USER_MAPPING_PATH = USER_MAPPING_PATH + "/confirm";
    public static final String LOGIN_MAPPING_PATH = "/login";

    public static final String CHARACTER_FANTASY_ID_PLACEHOLDER = "character-id";
    public static final String ID_PLACEHOLDER = "id";
    public static final String TOKEN_PLACEHOLDER = "token";

    public static final String ID_PLACEHOLDER_PATH = "/{" + ID_PLACEHOLDER + "}";
    public static final String CHARACTER_FANTASY_ID_PLACEHOLDER_PATH = "/{" + CHARACTER_FANTASY_ID_PLACEHOLDER + "}";
}
