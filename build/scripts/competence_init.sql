CREATE TABLE hackathon_test.competence (
  ID         BIGSERIAL NOT NULL,
  NAME VARCHAR(255),
  PRIMARY KEY (id)
);

INSERT INTO hackathon_test.competence (id, name) VALUES (1, 'Столяр');

CREATE TABLE hackathon_test.competence_user (
  ID         BIGSERIAL NOT NULL,
  competence_id INTEGER NOT NULL,
  USER_ID INTEGER NOT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE hackathon_test.competence_user
  ADD CONSTRAINT userIdFk
FOREIGN KEY (ID)
REFERENCES hackathon_test.USERS;

CREATE TABLE hackathon_test.competence_case (
  ID         BIGSERIAL NOT NULL,
  competence_id INTEGER NOT NULL,
  CASE_ID INTEGER NOT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE hackathon_test.competence_case
  ADD CONSTRAINT caseIdFk
FOREIGN KEY (ID)
REFERENCES hackathon_test.CASES;