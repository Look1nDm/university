package com.example.school2.utils;

import com.example.school2.dto.FacultyDto;
import com.example.school2.models.FacultyEntity;

import java.util.Collection;
import java.util.stream.Collectors;

public class FacultyUtils {
    public static FacultyDto migrateEntityToDto(FacultyEntity entity) {
        return new FacultyDto(entity.getId(),entity.getName(),entity.getColor());
    }
    public static FacultyEntity migrateDtoToEntity(FacultyDto dto) {
        return new FacultyEntity(dto.getIdFaculty(),dto.getName(),dto.getColor());
    }
    public static Collection<FacultyDto> migrateEntityToDtoCollection(Collection<FacultyEntity> list){
        return list.stream()
                .map(FacultyUtils::migrateEntityToDto).collect(Collectors.toList());
    }
    public static Collection<FacultyEntity> migrateDtoToEntityCollection(Collection<FacultyDto> list){
        return list.stream()
                .map(FacultyUtils::migrateDtoToEntity).collect(Collectors.toList());
    }
}
