package com.example.school2.controllers;

import com.example.school2.dto.AvatarDto;
import com.example.school2.models.AvatarEntity;
import com.example.school2.repositories.AvatarRepository;
import com.example.school2.services.AvatarServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/avatar")
public class AvatarController {
    private final AvatarServiceImpl avatarService;
    private final AvatarRepository avatarRepository;

    @PostMapping(value = "/{studentId}/avatar",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadAvatar(@PathVariable Long studentId,
                                               @RequestParam MultipartFile avatar) throws IOException {
        avatarService.uploadAvatar(studentId,avatar);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "/{id}/avatar-from-db")
    public ResponseEntity<byte[]> downloadAvatar(@PathVariable Long id) {
        AvatarEntity avatar = avatarRepository.findById(id).orElseThrow();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(avatar.getMediaType()));
        headers.setContentLength(avatar.getData().length);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(avatar.getData());
    }
    @GetMapping(value = "/{id}/avatar-from-file")
    public void downloadAvatar(@PathVariable Long id, HttpServletResponse response) throws IOException {
        AvatarEntity avatar = avatarService.findAvatar(id);
        Path path = Path.of(avatar.getFilePath());
        try (InputStream is = Files.newInputStream(path);
             OutputStream os = response.getOutputStream()) {
            response.setStatus(200);
            response.setContentType(avatar.getMediaType());
            response.setContentLength((int) avatar.getFileSize());
            is.transferTo(os);
        }
    }
    @GetMapping("/avatars-page")
    public Page avatarsPage(@RequestParam Integer page, Integer pageSize){
        return avatarService.getPageAvatars(page,pageSize);
    }
}
