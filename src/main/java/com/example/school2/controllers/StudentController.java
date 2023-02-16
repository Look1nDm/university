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
    /*
    endpoint create a new student
     */
    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentEntity entity) {
        return ResponseEntity.ok(studentService.createStudent(entity));
    }
    /*
    endpoint get a student
     */
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudent(id));
    }
    /*
    endpoint get all students
     */
    @GetMapping("/printAll")
    public ResponseEntity<Collection<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudentsDto());
    }
    /*
    endpoint get all students by age
     */
    @GetMapping("/age/{age}")
    public ResponseEntity<Collection<StudentDto>> getStudentByAge(@PathVariable Integer age) {
        return ResponseEntity.ok(studentService.getStudentsByAge(age));
    }
    /*
    endpoint get all students by age from and to
     */
    @GetMapping({"minAge", "maxAge"})
    public ResponseEntity<Collection<StudentDto>> getStudentsAgeByBetween(@RequestParam Integer minAge,
                                                                          @RequestParam Integer maxAge) {
        return ResponseEntity.ok(studentService.getStudentsByBetween(minAge, maxAge));
    }
    /*
    endpoint which faculty the student belongs to
     */
    @GetMapping("/{studentId}/faculty")
    public ResponseEntity<FacultyDto> getFacultyByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentService.findFacultyByStudentId(studentId));
    }
    /*
    endpoint get count all students
     */
    @GetMapping("/countStudents")
    public ResponseEntity<Long> getCountAllStudents() {
        return ResponseEntity.ok(studentService.getCountAllStudents());
    }
    /*
    endpoint get average age all students
     */
    @GetMapping("/avgAge")
    public ResponseEntity<Double> getAvgAgeStudents() {
        return ResponseEntity.ok(studentService.getAvgAgeStudents());
    }
    /*
    endpoint get last 5 students
     */
    @GetMapping("/lastFive")
    public ResponseEntity<Collection<StudentDto>> getFiveLastStudents() {
        return ResponseEntity.ok(studentService.getFiveLastStudents());
    }
    /*
    endpoint changes student
     */
    @PutMapping
    public ResponseEntity<StudentDto> setStudent(@RequestBody StudentEntity entity) {
        return ResponseEntity.ok(studentService.updateStudent(entity));
    }
    /*
    endpoint removes student
     */
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
    @GetMapping("/sixStudentsNames")
    public void getSixStudentsNames(){
        studentService.getSixStudentsNames();
    }
    @GetMapping("/synchronizedStudentsNames")
    public void synchronizedGetStudentsNames(){
        studentService.synchronizedGetStudentsNames();
    }
}
