CREATE TABLE hackathon_test.USERS
(
    ID   SERIAL PRIMARY KEY NOT NULL,
    NAME VARCHAR
);

insert into hackathon_test.USERS (NAME) values ('Test user');
