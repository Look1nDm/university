package com.example.school2.services;

import com.example.school2.utils.FacultyUtils;
import com.example.school2.utils.StudentUtils;
import com.example.school2.dto.FacultyDto;
import com.example.school2.dto.StudentDto;
import com.example.school2.models.StudentEntity;
import com.example.school2.repositories.FacultyRepository;
import com.example.school2.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;

    private final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Override
    public StudentDto createStudent(StudentEntity entity) {
        logger.info("Метод добавляет студента в базу");
        return StudentUtils.migrateEntityToDto(studentRepository.save(entity));
    }

    @Override
    public Collection<StudentDto> getAllStudentsDto(){
        logger.info("Метод возвращает всех студентов");
        return StudentUtils.migrateEntityToDtoCollection(studentRepository.findAll());
    }

    @Override
    public Collection<StudentDto> getStudentsByAge(Integer age) {
        logger.info("Метод возвращает всех студентов возратом: "+age);
        return StudentUtils.migrateEntityToDtoCollection(studentRepository.findStudentByAge(age));
    }

    @Override
    public Collection<StudentDto> getStudentsByBetween(Integer min, Integer max) {
        logger.info("Метод возвращает студентов возрастом в промежутке между: "+min+" and "+max);
        return StudentUtils.migrateEntityToDtoCollection(studentRepository.findByAgeBetween(min,max));
    }

    @Override
    public FacultyDto findFacultyByStudentId(Long studentId) {
        logger.info("Метод возвращает факультет студента№ "+studentId);
        return FacultyUtils.migrateEntityToDto(facultyRepository.findFacultyByStudentId(studentId));
    }

    @Override
    public StudentDto getStudent(Long id) {
        logger.info("Метод возвращает студента по его id "+id);
        return StudentUtils.migrateEntityToDto(studentRepository.findById(id).get());
    }

    @Override
    public StudentDto updateStudent(StudentEntity entity) {
        logger.info("Метод изменяет студента "+entity.getId()+" "+entity.getName());
        return StudentUtils.migrateEntityToDto(studentRepository.save(entity));
    }

    @Override
    public void deleteStudent(Long id) {
        logger.info("Метод удаляет студента №"+id);
        StudentDto studentDto = StudentUtils.migrateEntityToDto(studentRepository.findById(id).get());
        studentRepository.deleteById(studentDto.getIdStudent());
    }
    public Long getCountAllStudents(){
        logger.info("Метод возвращает общее количество студентов");
        return studentRepository.getAllCountOfStudents();
    }

    @Override
    public Double getAvgAgeStudents() {
        logger.info("Метод возвращает средний возвраст студента");
        return studentRepository.getAvgAgeStudents();
    }

    @Override
    public Collection<StudentDto> getFiveLastStudents() {
        logger.info("Метод возвращает 5 последних студентов из базы");
        return StudentUtils.migrateEntityToDtoCollection(studentRepository.findFiveLastStudents());
    }

    @Override
    public Collection<String> getAllStudentsWithFirstLatter(String firstLatter) {
        return getAllStudentsDto().stream()
                .map(e -> e.getName().toUpperCase()).sorted()
                .filter(e->e.startsWith(firstLatter.toUpperCase())).toList();
    }

    @Override
    public Double getAvgAgeStudentStream() {
        return getAllStudentsDto().stream()
                .mapToInt(StudentDto::getAge).average().orElseThrow();
    }
    @Override
    public void getSixStudentsNames() {
        List<String> listStudents = studentRepository.getNamesStudents();
        System.out.println(listStudents.get(0));
        System.out.println(listStudents.get(1));
        new Thread(()->{
            System.out.println(listStudents.get(2));
            System.out.println(listStudents.get(3));
        }).start();
        new Thread(()->{
            System.out.println(listStudents.get(4));
            System.out.println(listStudents.get(5));
        }).start();
    }
    @Override
    public void synchronizedGetStudentsNames() {
        printName(0,1);
        new Thread(()->{
            printName(2,3);
        }).start();
        new Thread(()->{
            printName(4,5);
        }).start();
    }
    public synchronized void printName(int name1,int name2){
        List<String> listStudents = studentRepository.getNamesStudents();
        System.out.println(listStudents.get(name1));
        System.out.println(listStudents.get(name2));
    }
}
