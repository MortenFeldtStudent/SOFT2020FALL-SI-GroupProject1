-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

DROP TABLE IF EXISTS person;

CREATE TABLE person (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  full_name VARCHAR(250) NOT NULL,
  year_of_birth INTEGER NOT NULL,
--  age INTEGER DEFAULT 0,
  zip_code INTEGER NOT NULL
--  town VARCHAR(250) DEFAULT '',
--  country VARCHAR(250) DEFAULT ''
);

--CREATE TABLE person (
--  id INTEGER PRIMARY KEY AUTO_INCREMENT,
--  full_name VARCHAR(250) NOT NULL,
--  year_of_birth INTEGER NOT NULL,
--  age INTEGER,
--  zip_code INTEGER NOT NULL,
--  town VARCHAR(250),
--  country VARCHAR(250)
--);