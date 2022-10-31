package com.example.school2.services;

import com.example.school2.dto.FacultyDto;
import com.example.school2.dto.StudentDto;
import com.example.school2.models.FacultyEntity;

import java.util.Collection;

public interface FacultyService {

    FacultyDto createFaculty(FacultyEntity entity);

    FacultyDto getFaculty(Long id);

    FacultyDto updateFaculty(FacultyEntity entity);

    void deleteFaculty(Long id);

    Collection<FacultyDto> getAllFaculties();
    FacultyDto getFacultyByColor(String color);
    FacultyDto getFacultyByName(String name);
    Collection<StudentDto> getStudentsOfFaculty(Long id);
    String getLongFacultyName();
}
