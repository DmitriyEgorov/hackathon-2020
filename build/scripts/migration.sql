-- Проливаем простыню, все скрипты перенесены
CREATE TABLE hackathon_test.CASES
(
    ID   SERIAL PRIMARY KEY NOT NULL,
    NAME VARCHAR
);

CREATE TABLE hackathon_test.CATEGORY
(
    ID   SERIAL PRIMARY KEY NOT NULL,
    NAME VARCHAR
);

ALTER TABLE hackathon_test.CASES
    add column category_id SERIAL NOT NULL;

update hackathon_test.cases
set category_id = 1
where id = 1;

ALTER TABLE Chackathon_test.ATEGORY
    add column parent_id SERIAL NOT NULL;

insert into CATEGORY(NAME)
VALUES ('Первая категория');

CREATE TABLE hackathon_test.competence
(
    ID   BIGSERIAL NOT NULL,
    NAME VARCHAR(255),
    PRIMARY KEY (id)
);

INSERT INTO hackathon_test.competence (id, name)
VALUES (1, 'Столяр');

CREATE TABLE hackathon_test.competence_user
(
    ID            BIGSERIAL NOT NULL,
    competence_id INTEGER   NOT NULL,
    USER_ID       INTEGER   NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE hackathon_test.competence_user
    ADD CONSTRAINT userIdFk
        FOREIGN KEY (ID)
            REFERENCES hackathon_test.USERS;

CREATE TABLE hackathon_test.competence_case
(
    ID            BIGSERIAL NOT NULL,
    competence_id INTEGER   NOT NULL,
    CASE_ID       INTEGER   NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE hackathon_test.competence_case
    ADD CONSTRAINT caseIdFk
        FOREIGN KEY (ID)
            REFERENCES hackathon_test.CASES;

CREATE TABLE hackathon_test.CRITERIA
(
    ID   SERIAL PRIMARY KEY NOT NULL,
    NAME VARCHAR
);

CREATE TABLE hackathon_test.CASE_TO_CRITERIA
(
    CASE_ID     INT NOT NULL,
    CRITERIA_ID INT NOT NULL,
    PRIMARY KEY (CRITERIA_ID, CASE_ID)
);

insert into hackathon_test.CRITERIA (NAME) values ('Стоимость');

insert into hackathon_test.CASE_TO_CRITERIA(CASE_ID, CRITERIA_ID) VALUES (1, 1);

CREATE TABLE hackathon_test.USERS
(
    ID   SERIAL PRIMARY KEY NOT NULL,
    NAME VARCHAR
);

insert into hackathon_test.USERS (NAME) values ('Test user');

CREATE TABLE hackathon_test.GRADES
(
    ID   SERIAL PRIMARY KEY NOT NULL,
    NAME VARCHAR NOT NULL,
    VALUE INT NOT NULL,
    AUTHOR_ID SERIAL NOT NULL
);

alter table GRADES
drop column name;

alter table GRADES
add column CASE_ID serial not null;

insert into GRADES(VALUE, AUTHOR_ID) values (7, 1);
update GRADES set CASE_ID = 1 where id = 1;
