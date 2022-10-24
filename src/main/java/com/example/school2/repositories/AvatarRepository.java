package com.example.school2.repositories;

import com.example.school2.models.AvatarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AvatarRepository extends JpaRepository<AvatarEntity,Long> {
}