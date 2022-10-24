package com.example.school2.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    public Long idStudent;
    public String name;
    public int age;
    public FacultyDto facultyDto;

    public StudentDto(Long idStudent, String name, int age) {
        this.idStudent = idStudent;
        this.name = name;
        this.age = age;
    }
}
