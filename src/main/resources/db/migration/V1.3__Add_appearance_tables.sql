CREATE TABLE public.gender
(
    id    VARCHAR(10)  NOT NULL,
    title VARCHAR(50) NOT NULL UNIQUE,
    CONSTRAINT pk_gender_id PRIMARY KEY (id)
);


COMMENT ON TABLE gender IS 'Gender';
COMMENT ON COLUMN gender.id IS 'id';
COMMENT ON COLUMN gender.title IS 'Gender title';

INSERT INTO public.type_of_body(id, type_body)
VALUES ('MALE', 'Male');
INSERT INTO public.type_of_body(id, type_body)
VALUES ('FEMALE', 'Female');
INSERT INTO public.type_of_body(id, type_body)
VALUES ('OTHER', 'Other gender/non specific');

CREATE TABLE public.race
(
    id           BIGINT       NOT NULL,
    name         VARCHAR(100) NOT NULL,
    lifespan     VARCHAR(50)  NOT NULL,
    height       VARCHAR(50)  NOT NULL,
    weight       VARCHAR(50)  NOT NULL,
    distinctions VARCHAR(50),
    description  TEXT,
    CONSTRAINT pk_race_id PRIMARY KEY (id)
);

COMMENT ON TABLE race IS 'Race';
COMMENT ON COLUMN race.name IS 'Name of the race';
COMMENT ON COLUMN race.lifespan IS 'Lifespan of the race';
COMMENT ON COLUMN race.height IS 'Typical height of the race';
COMMENT ON COLUMN race.weight IS 'Typical weight of the race';
COMMENT ON COLUMN race.distinctions IS 'Distinctions of the race';
COMMENT ON COLUMN race.description IS 'Description of the race';

CREATE SEQUENCE seq_race_id;

ALTER TABLE public.characterfantasy
    ADD COLUMN race_id BIGINT;

ALTER TABLE public.characterfantasy
    ADD CONSTRAINT fk_characterfantasy__race_id FOREIGN KEY (race_id)
        REFERENCES public.race (id)
        ON UPDATE CASCADE ON DELETE RESTRICT;

COMMENT ON COLUMN characterfantasy.race_id IS 'FK reference to the race';

CREATE TABLE public.type_of_body
(
    id        VARCHAR(20) NOT NULL,
    type_body VARCHAR(40) NOT NULL,

    CONSTRAINT pk_type_of_body_id PRIMARY KEY (id),
    CONSTRAINT uq_type_of_body__type_body UNIQUE (type_body)
);

COMMENT ON TABLE type_of_body IS 'Type of the body';
COMMENT ON COLUMN type_of_body.id IS 'Id';
COMMENT ON COLUMN type_of_body.type_body IS 'Type of the body';

INSERT INTO public.type_of_body(id, type_body)
VALUES ('RECTANGLE', 'Rectangle shape');
INSERT INTO public.type_of_body(id, type_body)
VALUES ('TRIANGLE', 'Triangle shape');
INSERT INTO public.type_of_body(id, type_body)
VALUES ('TRAPEZOID', 'Trapezoid shape');
INSERT INTO public.type_of_body(id, type_body)
VALUES ('OVAL', 'Oval shape');
INSERT INTO public.type_of_body(id, type_body)
VALUES ('INV_TRIANGLE', 'Inverted triangle shape');

CREATE TABLE public.shape_of_face
(
    id         VARCHAR(20) NOT NULL,
    shape_face VARCHAR(40) NOT NULL,

    CONSTRAINT pk_shape_of_face_id PRIMARY KEY (id),
    CONSTRAINT uq_shape_of_face__shape_face UNIQUE (shape_face)
);

COMMENT ON TABLE shape_of_face IS 'Shape of face';
COMMENT ON COLUMN shape_of_face.id IS 'Id';
COMMENT ON COLUMN shape_of_face.shape_face IS 'Shape of face';

INSERT INTO public.shape_of_face(id, shape_face)
VALUES ('SQUARE', 'Square shape');
INSERT INTO public.shape_of_face(id, shape_face)
VALUES ('ROUND', 'Round shape');
INSERT INTO public.shape_of_face(id, shape_face)
VALUES ('PEAR', 'Pear shape');
INSERT INTO public.shape_of_face(id, shape_face)
VALUES ('OVAL', 'Oval shape');
INSERT INTO public.shape_of_face(id, shape_face)
VALUES ('RECTANGLE', 'Rectangle shape');
INSERT INTO public.shape_of_face(id, shape_face)
VALUES ('DIAMOND', 'Diamond shape');
INSERT INTO public.shape_of_face(id, shape_face)
VALUES ('HEART', 'Heart shape');
INSERT INTO public.shape_of_face(id, shape_face)
VALUES ('TRIANGLE', 'Triangle shape');

CREATE TABLE public.appearance
(
    id                  BIGINT         NOT NULL,
    age                 INT,
    age_of_appearance   INT,
    glasses             BOOLEAN DEFAULT FALSE NOT NULL,
    weight              DECIMAL(10, 2) NOT NULL,
    height              DECIMAL(10, 2) NOT NULL,
    eye_color           VARCHAR(10),
    skin_color          VARCHAR(10),
    type_of_body        VARCHAR(20) NOT NULL,
    shape_of_face       VARCHAR(20) NOT NULL,
    gender_id           VARCHAR(10),
    char_id BIGINT         NOT NULL,
    predominant_feature VARCHAR(100),
    posture             VARCHAR(50),
    description         TEXT,
    CONSTRAINT pk_appearance_id PRIMARY KEY (id),

    CONSTRAINT fk_appearance__gender_id
        FOREIGN KEY (gender_id) REFERENCES public.gender (id)
            ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_appearance__char_id
        FOREIGN KEY (char_id) REFERENCES public.characterfantasy (id)
            ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT ck_appearance__type_of_body
        CHECK(type_of_body = ANY (ARRAY['RECTANGLE','TRIANGLE','TRAPEZOID','OVAL', 'INV_TRIANGLE'])),
    CONSTRAINT ck_appearance__shape_of_face
        CHECK(shape_of_face = ANY (ARRAY['SQUARE','ROUND','PEAR','OVAL','RECTANGLE','DIAMOND','HEART','TRIANGLE']))
);

CREATE SEQUENCE seq_appearance_id;

COMMENT ON TABLE appearance IS 'Character appearance';
COMMENT ON COLUMN appearance.id IS 'Id';
COMMENT ON COLUMN appearance.age IS 'age of the character';
COMMENT ON COLUMN appearance.age_of_appearance IS 'how old does the character appear';
COMMENT ON COLUMN appearance.glasses IS 'if has glasses';
COMMENT ON COLUMN appearance.weight IS 'weight';
COMMENT ON COLUMN appearance.height IS 'height';
COMMENT ON COLUMN appearance.eye_color IS 'eye color';
COMMENT ON COLUMN appearance.skin_color IS 'skin color';
COMMENT ON COLUMN appearance.type_of_body IS 'type of body as enum of [RECTANGLE,TRIANGLE,TRAPEZOID,OVAL,INV_TRIANGLE]';
COMMENT ON COLUMN appearance.shape_of_face IS 'shape of face as enum of [SQUARE,ROUND,PEAR,OVAL,RECTANGLE,DIAMOND,HEART,TRIANGLE]';
COMMENT ON COLUMN appearance.gender_id IS 'gender FK';
COMMENT ON COLUMN appearance.characterfantasy_id IS 'character fantasy FK';
COMMENT ON COLUMN appearance.predominant_feature IS 'predominant feature';
COMMENT ON COLUMN appearance.posture IS 'posture';
COMMENT ON COLUMN appearance.description IS 'description as markdown';