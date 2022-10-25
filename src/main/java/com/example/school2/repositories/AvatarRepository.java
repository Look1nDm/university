package com.example.school2.repositories;

import com.example.school2.models.AvatarEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AvatarRepository extends PagingAndSortingRepository<AvatarEntity,Long> {

}