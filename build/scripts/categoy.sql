CREATE TABLE hackathon_test.CATEGORY
(
    ID   SERIAL PRIMARY KEY NOT NULL,
    NAME VARCHAR
);

ALTER TABLE hackathon_test.CASES
    add column category_id SERIAL NOT NULL;

update hackathon_test.cases set category_id = 1 where id = 1;

ALTER TABLE hackathon_test.CATEGORY
    add column parent_id SERIAL NOT NULL;

insert into hackathon_test.CATEGORY(NAME) VALUES ('Первая категория');
