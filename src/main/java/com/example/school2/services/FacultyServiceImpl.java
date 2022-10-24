package com.example.school2.services;

import com.example.school2.utils.FacultyUtils;
import com.example.school2.utils.StudentUtils;
import com.example.school2.dto.FacultyDto;
import com.example.school2.dto.StudentDto;
import com.example.school2.models.FacultyEntity;
import com.example.school2.repositories.FacultyRepository;
import com.example.school2.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;

    @Override
    public FacultyDto createFaculty(FacultyEntity entity) {
        return FacultyUtils.migrateEntityToDto(facultyRepository.save(entity));
    }

    @Override
    public FacultyDto getFaculty(Long id) {
        return FacultyUtils.migrateEntityToDto(facultyRepository.findById(id).get());
    }

    @Override
    public FacultyDto updateFaculty(FacultyEntity entity) {
        return FacultyUtils.migrateEntityToDto(facultyRepository.save(entity));
    }

    @Override
    public void deleteFaculty(Long id) {
        FacultyDto facultyDto = FacultyUtils.migrateEntityToDto(facultyRepository.findById(id).get());
        facultyRepository.deleteById(facultyDto.getIdFaculty());
    }

    @Override
    public Collection<FacultyDto> getAllFaculties() {
        return FacultyUtils.migrateEntityToDtoCollection(facultyRepository.findAll());
    }

    @Override
    public FacultyDto getFacultyByColor(String color) {

        return FacultyUtils.migrateEntityToDto(facultyRepository.findFacultyByColorIgnoreCase(color));
    }

    @Override
    public FacultyDto getFacultyByName(String name) {
        return FacultyUtils.migrateEntityToDto(facultyRepository.findFacultyByNameIgnoreCase(name));
    }

    public Collection<StudentDto> getStudentsOfFaculty(Long id) {
        return StudentUtils.migrateEntityToDtoCollection(studentRepository.findStudentEntityByFacultyId(id));
    }
}
