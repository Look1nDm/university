--liquibase formatted sql
--changeset dlukin:1
CREATE INDEX students_name_index ON student_entity (name);
CREATE INDEX faculty_name_and_color_index ON faculty_entity (name,color)