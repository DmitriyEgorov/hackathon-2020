-- drop old schema and user
DROP SCHEMA IF EXISTS hackathon CASCADE;
DROP USER IF EXISTS hackathon;
-- create schema, user, rights
CREATE USER hackathon_test WITH PASSWORD 'hackathon_test';
CREATE SCHEMA hackathon_test;
GRANT USAGE ON SCHEMA hackathon_test TO hackathon_test;
ALTER DEFAULT PRIVILEGES IN SCHEMA hackathon_test GRANT ALL ON TABLES TO hackathon_test;
ALTER DEFAULT PRIVILEGES IN SCHEMA hackathon_test GRANT ALL ON SEQUENCES TO hackathon_test;

--test table with data
CREATE TABLE hackathon_test.TEST_DATA (
  ID         BIGSERIAL NOT NULL,
  DATA VARCHAR(255),
  PRIMARY KEY (id)
);

INSERT INTO hackathon_test.test_data (id, data) VALUES (1, 'Scorpions You and I');
