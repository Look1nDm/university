select name FROM student_entity;
select * from student_entity where age between 17 and 19;
select * from student_entity where name like '%M%' and name like '%L%';
select * from student_entity where age<18;
select * from student_entity order by age;
select name,age from student_entity order by age desc;