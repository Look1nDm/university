package com.example.school2.dto;

import com.example.school2.models.StudentEntity;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDto {
    public Long idFaculty;
    public String name;
    public String color;
    public Set<StudentEntity> students;

    public FacultyDto(Long idFaculty, String name, String color) {
        this.idFaculty = idFaculty;
        this.name = name;
        this.color = color;
    }
}