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
