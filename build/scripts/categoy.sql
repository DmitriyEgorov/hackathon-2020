CREATE TABLE CATEGORY
(
    ID   SERIAL PRIMARY KEY NOT NULL,
    NAME VARCHAR
);

ALTER TABLE CASES
    add column category_id SERIAL NOT NULL;

update cases set category_id = 1 where id = 1;

ALTER TABLE CATEGORY
    add column parent_id SERIAL NOT NULL;

insert into CATEGORY(NAME) VALUES ('Первая категория');
