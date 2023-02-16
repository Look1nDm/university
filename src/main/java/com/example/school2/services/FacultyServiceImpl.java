package com.example.school2.services;

import com.example.school2.utils.FacultyUtils;
import com.example.school2.utils.StudentUtils;
import com.example.school2.dto.FacultyDto;
import com.example.school2.dto.StudentDto;
import com.example.school2.models.FacultyEntity;
import com.example.school2.repositories.FacultyRepository;
import com.example.school2.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;

    private final Logger logger = LoggerFactory.getLogger(FacultyServiceImpl.class);

    @Override
    public FacultyDto createFaculty(FacultyEntity entity) {
        logger.info("Метод добавляет факультет "+entity.getName()+" в базу");
        return FacultyUtils.migrateEntityToDto(facultyRepository.save(entity));
    }

    @Override
    public FacultyDto getFaculty(Long id) {
        logger.info("Метод возвращает факультет№"+id+" из базы");
        return FacultyUtils.migrateEntityToDto(facultyRepository.findById(id).get());
    }

    @Override
    public FacultyDto updateFaculty(FacultyEntity entity) {
        logger.info("Метод изменяет факультет "+entity.getName());
        return FacultyUtils.migrateEntityToDto(facultyRepository.save(entity));
    }

    @Override
    public void deleteFaculty(Long id) {
        logger.info("Метод удаляет факультет "+ id);
        FacultyDto facultyDto = FacultyUtils.migrateEntityToDto(facultyRepository.findById(id).get());
        facultyRepository.deleteById(facultyDto.getIdFaculty());
    }

    @Override
    public Collection<FacultyDto> getAllFaculties() {
        logger.info("Метод возвращает все факультеты");
        return FacultyUtils.migrateEntityToDtoCollection(facultyRepository.findAll());
    }

    @Override
    public FacultyDto getFacultyByColor(String color) {
        logger.info("Метод возвращает факульет, которому присущь цвет "+color);
        return FacultyUtils.migrateEntityToDto(facultyRepository.findFacultyByColorIgnoreCase(color));
    }

    @Override
    public FacultyDto getFacultyByName(String name) {
        logger.info("Метод ивзвращает факультет "+ name);
        return FacultyUtils.migrateEntityToDto(facultyRepository.findFacultyByNameIgnoreCase(name));
    }

    public Collection<StudentDto> getStudentsOfFaculty(Long id) {
        logger.info(" Метод возвращает студентов, обущающихся на фаультете № "+id);
        return StudentUtils.migrateEntityToDtoCollection(studentRepository.findStudentEntityByFacultyId(id));
    }

    @Override
    public String getLongFacultyName() {
        return String.valueOf(getAllFaculties().stream()
                .map(FacultyDto::getName)
                .max(Comparator.comparing(String::length)).orElseThrow());
    }
    public Integer megaSum(){
        return Stream.iterate(1, a -> a +1).parallel()
                .limit(1_000_000)
                .reduce(0, Integer::sum);
    }
}
