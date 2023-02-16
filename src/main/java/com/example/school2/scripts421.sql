ALTER TABLE student_entity ADD CONSTRAINT age_constraint CHECK ( age >= 16 );
ALTER TABLE student_entity ALTER COLUMN name SET NOT NULL;
ALTER TABLE student_entity ADD CONSTRAINT name_constraint UNIQUE (name);
ALTER TABLE faculty_entity ADD CONSTRAINT facultyName_color_constraint UNIQUE (name,color);
ALTER TABLE student_entity ALTER COLUMN age SET DEFAULT 20;