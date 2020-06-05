CREATE TABLE hackathon_test.competence (
  ID         BIGSERIAL NOT NULL,
  NAME VARCHAR(255),
  PRIMARY KEY (id)
);

INSERT INTO hackathon_test.competence (id, name) VALUES (1, 'Столяр');