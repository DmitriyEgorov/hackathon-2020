-- drop old schema and user
DROP SCHEMA IF EXISTS hackathon_stub CASCADE;
DROP USER IF EXISTS hackathon_stub;
-- create schema, user, rights
CREATE USER hackathon_stub WITH PASSWORD 'hackathon_stub';
CREATE SCHEMA hackathon_stub;
GRANT USAGE ON SCHEMA hackathon_stub TO hackathon_stub;
ALTER DEFAULT PRIVILEGES IN SCHEMA hackathon_stub GRANT ALL ON TABLES TO hackathon_stub;
ALTER DEFAULT PRIVILEGES IN SCHEMA hackathon_stub GRANT ALL ON SEQUENCES TO hackathon_stub;

--test table with data
CREATE TABLE hackathon_stub.TEST_STUB_DATA (
  ID         BIGSERIAL NOT NULL,
  DATA VARCHAR(255),
  PRIMARY KEY (id)
);

INSERT INTO hackathon_stub.TEST_STUB_DATA (id, data) VALUES (1, 'Scorpions wind of change');
