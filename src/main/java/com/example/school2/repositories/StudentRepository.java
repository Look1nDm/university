package com.example.school2.repositories;
import com.example.school2.models.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Collection<StudentEntity> findStudentByAge(Integer age);

    Collection<StudentEntity> findByAgeBetween(Integer min, Integer max);

    Collection<StudentEntity> findStudentEntityByFacultyId(Long number);

    @Query(value = "SELECT count(id) FROM student_entity", nativeQuery = true)
    Long getAllCountOfStudents();

    @Query(value = "SELECT AVG (age) FROM student_entity", nativeQuery = true)
    Double getAvgAgeStudents();

    @Query(value = "SELECT * FROM student_entity ORDER BY id DESC LIMIT 5", nativeQuery = true)
    Collection<StudentEntity> findFiveLastStudents();
}
