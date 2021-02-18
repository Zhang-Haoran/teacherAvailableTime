package com.aiEnglish.teacherAvailableTime.controllers;

import com.aiEnglish.teacherAvailableTime.dtos.englishClass.EnglishClassGetDto;
import com.aiEnglish.teacherAvailableTime.dtos.englishClass.EnglishClassPostDto;
import com.aiEnglish.teacherAvailableTime.entities.EnglishClass;
import com.aiEnglish.teacherAvailableTime.services.EnglishClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/englishclass")
public class EnglishClassController {
    private final EnglishClassService englishClassService;

    @GetMapping
    public ResponseEntity<List<EnglishClassGetDto>> findAll() {
        return ResponseEntity.ok(englishClassService.getAllEnglishClasses());
    }

    @PostMapping
    public ResponseEntity<EnglishClassGetDto> create(@RequestBody EnglishClassPostDto englishClassPostDto) {
       return ResponseEntity.ok(englishClassService.create(englishClassPostDto));
    }
}
