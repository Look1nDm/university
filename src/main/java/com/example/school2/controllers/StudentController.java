package com.example.school2.controllers;

import com.example.school2.dto.FacultyDto;
import com.example.school2.dto.StudentDto;
import com.example.school2.models.StudentEntity;
import com.example.school2.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentEntity entity) {
        return ResponseEntity.ok(studentService.createStudent(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @GetMapping("/printAll")
    public ResponseEntity<Collection<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudentsDto());
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<Collection<StudentDto>> getStudentByAge(@PathVariable Integer age) {
        return ResponseEntity.ok(studentService.getStudentsByAge(age));
    }

    @GetMapping({"minAge", "maxAge"})
    public ResponseEntity<Collection<StudentDto>> getStudentsAgeByBetween(@RequestParam Integer minAge,
                                                                          @RequestParam Integer maxAge) {
        return ResponseEntity.ok(studentService.getStudentsByBetween(minAge, maxAge));
    }

    @GetMapping("/{studentId}/faculty")
    public ResponseEntity<FacultyDto> getFacultyByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentService.findFacultyByStudentId(studentId));
    }

    @GetMapping("/countStudents")
    public ResponseEntity<Long> getCountAllStudents() {
        return ResponseEntity.ok(studentService.getCountAllStudents());
    }

    @GetMapping("/avgAge")
    public ResponseEntity<Double> getAvgAgeStudents() {
        return ResponseEntity.ok(studentService.getAvgAgeStudents());
    }

    @GetMapping("/lastFive")
    public ResponseEntity<Collection<StudentDto>> getFiveLastStudents() {
        return ResponseEntity.ok(studentService.getFiveLastStudents());
    }

    @PutMapping
    public ResponseEntity<StudentDto> setStudent(@RequestBody StudentEntity entity) {
        return ResponseEntity.ok(studentService.updateStudent(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDto> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/all/{firstLatter}")
    public ResponseEntity<Collection<String>> getAllStudentsStartName(@PathVariable String firstLatter){
        return ResponseEntity.ok(studentService.getAllStudentsWithFirstLatter(firstLatter));
    }
    @GetMapping("/avgAgeStudents")
    public ResponseEntity<Double> getAvgAge(){
        return ResponseEntity.ok(studentService.getAvgAgeStudentStream());
    }
}
