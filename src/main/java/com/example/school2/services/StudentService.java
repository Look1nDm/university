package com.example.school2.services;

import com.example.school2.dto.FacultyDto;
import com.example.school2.dto.StudentDto;
import com.example.school2.models.StudentEntity;

import java.util.Collection;

public interface StudentService {
    StudentDto createStudent(StudentEntity entity);

    StudentDto getStudent(Long id);

    StudentDto updateStudent(StudentEntity entity);

    void deleteStudent(Long id);

    Collection<StudentDto> getAllStudentsDto();

    Collection<StudentDto> getStudentsByAge(Integer age);

    Collection<StudentDto> getStudentsByBetween(Integer min,Integer max);

    FacultyDto findFacultyByStudentId(Long studentId);
    Long getCountAllStudents();
    Double getAvgAgeStudents();
    Collection<StudentDto> getFiveLastStudents();

    Collection<String> getAllStudentsWithFirstLatter(String startName);

    Double getAvgAgeStudentStream();
}
