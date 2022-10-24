package com.example.school2.controllers;

import com.example.school2.dto.FacultyDto;
import com.example.school2.dto.StudentDto;
import com.example.school2.models.FacultyEntity;
import com.example.school2.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    @PostMapping("/create")
    public ResponseEntity<FacultyDto> createStudent(@RequestBody FacultyEntity entity) {
        return ResponseEntity.ok(facultyService.createFaculty(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultyDto> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(facultyService.getFaculty(id));
    }

    @GetMapping("/printAll")
    public ResponseEntity<Collection<FacultyDto>> getAllFaculties() {
        return ResponseEntity.ok(facultyService.getAllFaculties());
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<FacultyDto> getFacultyByColor(@PathVariable String color) {
        return ResponseEntity.ok(facultyService.getFacultyByColor(color));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<FacultyDto> getFacultyByName(@PathVariable String name) {
        return ResponseEntity.ok(facultyService.getFacultyByName(name));
    }
    @GetMapping("/{numberFaculty}/students")
    public ResponseEntity<Collection<StudentDto>> getStudentsOfFaculty(@PathVariable Long numberFaculty){
        if (numberFaculty != null) {
            return ResponseEntity.ok(facultyService.getStudentsOfFaculty(numberFaculty));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<FacultyDto> setStudent(@RequestBody FacultyEntity entity) {
        return ResponseEntity.ok(facultyService.updateFaculty(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FacultyDto> deleteStudent(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }
}
