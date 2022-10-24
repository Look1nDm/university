package com.example.school2.utils;

import com.example.school2.dto.StudentDto;
import com.example.school2.models.StudentEntity;

import java.util.Collection;
import java.util.stream.Collectors;

public class StudentUtils {
    public static StudentDto migrateEntityToDto(StudentEntity entity) {
        return new StudentDto(entity.getId(),entity.getName(),entity.getAge());
    }

    public static StudentEntity migrateDtoToEntity(StudentDto dto) {
        return new StudentEntity(dto.getIdStudent(),dto.getName(),dto.getAge());
    }

    public static Collection<StudentDto> migrateEntityToDtoCollection(Collection<StudentEntity> list) {
        return list.stream()
                .map(StudentUtils::migrateEntityToDto).collect(Collectors.toList());
    }

    public static Collection<StudentEntity> migrateDtoToEntityCollection(Collection<StudentDto> list) {
        return list.stream()
                .map(StudentUtils::migrateDtoToEntity).collect(Collectors.toList());
    }
}
