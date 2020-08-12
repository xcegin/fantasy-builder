CREATE TABLE public.characterfantasy (
                        id BIGINT NOT NULL,
                        codename VARCHAR(50) NOT NULL,
                        CONSTRAINT pk_char_id PRIMARY KEY (id)
);

COMMENT ON TABLE characterfantasy IS 'Characters name';
COMMENT ON COLUMN characterfantasy.codename IS 'Codename of the character';
COMMENT ON COLUMN characterfantasy.id IS 'id';

CREATE SEQUENCE seq_characterfantasy_id;