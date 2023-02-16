SELECT student_entity.name, student_entity.age, faculty_id.name FROM student_entity
INNER JOIN faculty_entity fe ON student_entity.faculty_id = fe.id;

SELECT student_entity.name FROM student_entity
INNER JOIN avatar_entity ae on student_entity.id = ae.student_id;