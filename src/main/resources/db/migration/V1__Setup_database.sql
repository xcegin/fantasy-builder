CREATE TABLE public.Relation (
                                         id BIGINT NOT NULL,
                                         description VARCHAR(50) NOT NULL,

                                         CONSTRAINT pk_relation_id PRIMARY KEY (id)
);

COMMENT ON TABLE Relation IS 'Relation between characters';
COMMENT ON COLUMN Relation.id IS 'id';
COMMENT ON COLUMN Relation.description IS 'relation description';

CREATE SEQUENCE seq_relation_id;