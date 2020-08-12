CREATE TABLE public.char_name
(
    id          BIGINT      NOT NULL,
    char_name   VARCHAR(50) NOT NULL,
    description VARCHAR(500),
    is_alias    BOOLEAN     NOT NULL DEFAULT FALSE,
    char_id     BIGINT      NOT NULL,

    CONSTRAINT pk_char_name_id PRIMARY KEY (id),
    CONSTRAINT fk_char_name__currency_id
        FOREIGN KEY (char_id) REFERENCES public.characterfantasy (id)
            ON UPDATE CASCADE ON DELETE CASCADE
);

COMMENT ON TABLE char_name IS 'Characters name or alias';
COMMENT ON COLUMN char_name.id IS 'id';
COMMENT ON COLUMN char_name.char_name IS 'name itself';
COMMENT ON COLUMN char_name.description IS 'description of the characters name, origin, etc.';
COMMENT ON COLUMN char_name.is_alias IS 'is alias, default false';
COMMENT ON COLUMN char_name.char_id IS 'fk to CharacterFantasy';

CREATE SEQUENCE seq_char_name_id;