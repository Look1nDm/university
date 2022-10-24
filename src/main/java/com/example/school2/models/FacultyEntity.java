package com.example.school2.models;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
@Getter
@Setter
@Entity
public class FacultyEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String color;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "faculty")
    private Set<StudentEntity> student;

    public FacultyEntity(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public FacultyEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyEntity that = (FacultyEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(color, that.color) && Objects.equals(student, that.student);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, color, student);
    }
}