package com.example.school2.repositories;

import com.example.school2.models.FacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<FacultyEntity,Long> {
    FacultyEntity findFacultyByColorIgnoreCase(String color);
    FacultyEntity findFacultyByNameIgnoreCase(String name);

    FacultyEntity findFacultyByStudentId(Long studentId);
}
