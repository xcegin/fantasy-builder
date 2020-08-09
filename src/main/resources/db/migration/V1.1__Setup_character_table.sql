CREATE TABLE public.CharacterFantasy (
                        id BIGINT NOT NULL,
                        char_name VARCHAR(50) NOT NULL,

                        CONSTRAINT pk_char_id PRIMARY KEY (id),
                        CONSTRAINT uq_char_char_name UNIQUE (char_name)
);

COMMENT ON TABLE CharacterFantasy IS 'Characters name';
COMMENT ON COLUMN CharacterFantasy.id IS 'id';
COMMENT ON COLUMN CharacterFantasy.char_name IS 'unique character name';

CREATE SEQUENCE seq_character_id;