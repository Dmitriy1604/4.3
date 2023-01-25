-- liquibase formatted sql

-- changeset scherbakov:1
CREATE TABLE faculty
(
    id    SERIAL PRIMARY KEY,
    name  varchar(255),
    color varchar(255)
);

-- changeset scherbakov:2
CREATE TABLE avatar
(
    id         SERIAL PRIMARY KEY,
    file_path  varchar(255),
    file_size  BIGINT,
    media_type varchar(255),
    data       BYTEA
);

-- changeset scherbakov:3
CREATE TABLE student
(
    id         SERIAL PRIMARY KEY,
    name       varchar(255),
    age        INT,
    faculty_id BIGINT REFERENCES faculty (id),
    avatar_id  BIGINT REFERENCES avatar (id)
);



