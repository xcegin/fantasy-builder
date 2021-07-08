CREATE TABLE public.user_entity
(
    id          BIGINT      NOT NULL,
    first_name   VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    password    VARCHAR(200) NOT NULL,
    email     VARCHAR(100) NOT NULL UNIQUE,
    enabled             BOOLEAN DEFAULT FALSE NOT NULL,

    CONSTRAINT pk_user_entity_id PRIMARY KEY (id)
);

COMMENT ON TABLE user_entity IS 'User entity';
COMMENT ON COLUMN user_entity.id IS 'id';
COMMENT ON COLUMN user_entity.first_name IS 'User first name';
COMMENT ON COLUMN user_entity.last_name IS 'User last name';
COMMENT ON COLUMN user_entity.password IS 'User password hash';
COMMENT ON COLUMN user_entity.email IS 'Email of user';
COMMENT ON COLUMN user_entity.enabled IS 'If user is enabled';


CREATE SEQUENCE seq_user_entity_id;

CREATE TABLE public.confirmation_token
(
    id          BIGINT      NOT NULL,
    confirmation_token   VARCHAR(200) NOT NULL,
    created_date TIMESTAMP WITHOUT TIME ZONE,
    user_id     BIGINT NOT NULL,
    CONSTRAINT fk_confirmation_token__user_id
        FOREIGN KEY (user_id) REFERENCES public.user_entity (id)
            ON UPDATE CASCADE ON DELETE CASCADE,

    CONSTRAINT pk_confirmation_token_id PRIMARY KEY (id)
);

COMMENT ON TABLE confirmation_token IS 'Confirmation token';
COMMENT ON COLUMN confirmation_token.id IS 'id';
COMMENT ON COLUMN confirmation_token.confirmation_token IS 'Confirmation token value';
COMMENT ON COLUMN confirmation_token.created_date IS 'Created date';
COMMENT ON COLUMN confirmation_token.user_id IS 'User id for one to one';


CREATE SEQUENCE seq_confirmation_token_id;