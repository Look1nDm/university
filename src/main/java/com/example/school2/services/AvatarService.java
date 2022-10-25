package com.example.school2.services;

import com.example.school2.dto.AvatarDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

public interface AvatarService {
    void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException;
    PageRequest getPageAvatars(Integer page, Integer pageSize);
}
